package scalaTest.spark

import org.apache.spark.ml.PipelineModel
import org.apache.spark.sql.types._
import org.apache.spark.sql._
import org.scalatest.FunSuite
import org.talend.dataquality.reconciliation.indexing._
import org.apache.spark.SparkContext
import org.apache.spark.sql.catalyst.expressions._

class DataFrameTest {
  
}

/**
  * Created by root on 9/21/16.
  */
object DataFrameTest {
   @transient var spark: SparkSession = _
  @transient var sc: SparkContext = _
   spark = SparkSession.builder
    .master("local[2]")
    .appName("IndexingTest")
    .config("spark.sql.shuffle.partitions", "3") // makes small tests much faster
    //      .config("es.index.auto.create", "true")
    //      .config("es.batch.size.entries", "5000")
    //      .config("es.batch.size.bytes", "15M")
    //.config("spark.es.nodes", "62.210.103.100") // for remote ES
    .getOrCreate()
  //spark.conf.set("spark.sql.shuffle.partitions", 4)
  sc = spark.sparkContext
  // sc is an existing SparkContext.
  val sqlContext = new org.apache.spark.sql.SQLContext(sc)
  // this is used to implicitly convert an RDD to a DataFrame.
  import sqlContext.implicits._
  

 
  def main(args: Array[String]) {
    
  val df = spark.createDataset(Seq(("aaa", 1, 2), ("bbb", 3, 4), ("ccc", 3, 5), ("bbb", 4, 6))).toDF("key1","key2","key3")
  df.printSchema
  df.show()
  println(df.collect.mkString("<", ",", ">"))
  df.collect.foreach {println}
  println("\"key1\"")
  df.select("key1").collect.foreach {println}
  println("$\"key1\"")
  df.select($"key1").collect.foreach {println}
  println("df.col(\"key1\")")
  df.select(df.col("key1")).collect.foreach {println}
  println("upper(key1), key2 as haha2")
  df.selectExpr("upper(key1)", "key2 as haha2").show()
  df.selectExpr("upper(key1)", "key2 as haha2").collect.foreach {println}
  df.schema.fieldNames.foreach(println)
  }
}