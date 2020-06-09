package scalaTest.spark

import org.apache.spark.ml.PipelineModel
import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, Row}
import org.scalatest.FunSuite
import org.talend.dataquality.reconciliation.indexing.TestContext
import org.apache.spark.SparkContext
import org.apache.spark.sql.{SQLContext, SQLImplicits, SparkSession}
import org.apache.spark.sql.types.DoubleType

class ChangeValueTo1Reduce {
  
}

object ChangeValueTo1Reduce{
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

  def main(args: Array[String]): Unit = {
    val rdd = sc.parallelize(List((1, 1), (1, 2), (1, 3), (2, 1), (2, 2), (2, 3)), 1)
    //先改成1然后再相加最后计算出个数
    val rdd1 =  rdd.mapValues(x=>1L).reduceByKey(_ + _)
     println(rdd1.collect.toMap)
    rdd1.foreachPartition(it => {
      while (it.hasNext) {
        println(it.next)
      }
      println("================")
    })
  }
}