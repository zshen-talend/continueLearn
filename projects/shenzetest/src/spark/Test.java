// ============================================================================
//
// Copyright (C) 2006-2020 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package spark;




import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        SparkConf conf = new SparkConf().setAppName("Line_Count").setMaster("local[2]");
        JavaSparkContext ctx = new JavaSparkContext(conf);

        JavaRDD<String> textLoadRDD = ctx.textFile("C:/spark/README.md");
        System.out.println(textLoadRDD.count());
        System.getProperty("java.io.tmpdir");

    }

    }

