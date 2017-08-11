package spark;

import java.util.ArrayList;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructType;

public class RDD2DataFrameByProgrammatically {

    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("RDD2DataFrameByProgrammatically");
        JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext sqlContext = new SQLContext(sc);
        JavaRDD lines = sc.textFile("C://Users//DS01//Desktop//persons.txt");

        JavaRDD personsRDD = lines.map(new Function<String, Row>() {

            @Override
            public Row call(String line) throws Exception {
                String[] splited = line.split(",");
                return RowFactory.create(Integer.valueOf(splited[0]), splited[1], Integer.valueOf(splited[2]));
            }
        });

        List structFields = new ArrayList();
        // 用循环的方式进行添加。最佳实践，数据库的列不要超过32列。当然，Spark对此没有限制
        structFields.add(DataTypes.createStructField("id", DataTypes.IntegerType, true));
        structFields.add(DataTypes.createStructField("name", DataTypes.StringType, true));
        structFields.add(DataTypes.createStructField("age", DataTypes.IntegerType, true));
        StructType structType = DataTypes.createStructType(structFields);// 构建StructType，用于最后DataFrame元数据的描述

        org.apache.spark.sql.Dataset<Row> personsDF = sqlContext.createDataFrame(personsRDD, structType);

        personsDF.registerTempTable("persons");// 背后发生的不是现在考虑的

        org.apache.spark.sql.Dataset<Row> result = sqlContext.sql("select * from persons where age > 10");

        List<Row> listRow = result.javaRDD().collect();
        for (Row row : listRow) {
            System.out.println(row);
        }
    }
}