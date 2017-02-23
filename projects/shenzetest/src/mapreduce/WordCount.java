// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package mapreduce;



  import java.io.IOException;
import java.security.PrivilegedExceptionAction;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.hadoop.security.UserGroupInformation;

public class WordCount extends Configured {

     public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
       private final static IntWritable one = new IntWritable(1);
       private Text word = new Text();

       public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
         String line = value.toString();
         StringTokenizer tokenizer = new StringTokenizer(line);
         while (tokenizer.hasMoreTokens()) {
           word.set(tokenizer.nextToken());
           output.collect(word, one);
         }
       }
     }

     public static class Reduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
       public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
         int sum = 0;
         while (values.hasNext()) {
           sum += values.next().get();
         }
         output.collect(key, new IntWritable(sum));
       }
     }

     public static void main(String[] args) throws Exception {
         UserGroupInformation ugi = UserGroupInformation.createRemoteUser("tdq");
        ugi.doAs(new PrivilegedExceptionAction<Void>() {
//
            public Void run() throws Exception {

                JobConf conf = new JobConf(WordCount.class);
                FileSystem.setDefaultUri(conf, "hdfs://hadoopmaster1.talend.lan:8020/");
                conf.set("mapred.job.tracker", "hadoopmaster1.talend.lan:50300");
                conf.setJobName("wordcount");

                conf.setOutputKeyClass(Text.class);
                conf.setOutputValueClass(IntWritable.class);

                conf.setMapperClass(Map.class);
                conf.setCombinerClass(Reduce.class);
                conf.setReducerClass(Reduce.class);

                conf.setInputFormat(TextInputFormat.class);
                conf.setOutputFormat(TextOutputFormat.class);

                // conf.setJar("hadoopTest.jar");

                FileInputFormat.setInputPaths(conf, new Path("/user/tdq/shenzetest1/tMatchGroupHadoop_1/in"));
                FileOutputFormat.setOutputPath(conf, new Path("/user/tdq/shenzetest1/tMatchGroupHadoop_1/test"));
                FileSystem fs = FileSystem.get(conf);
                fs.delete(new Path("/user/tdq/shenzetest1/tMatchGroupHadoop_1/test"), true);
                JobClient.runJob(conf);
                return null;
            }
        });

     }


 }



