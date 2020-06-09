package scalaTest.spark

import org.apache.spark.ml.PipelineModel
import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, Row}
import org.scalatest.FunSuite
import org.talend.dataquality.reconciliation.indexing.TestContext
import org.apache.spark.SparkContext
import org.apache.spark.sql.{SQLContext, SQLImplicits, SparkSession}
import org.apache.spark.sql.types.DoubleType

class glomTest {
  
}

object glomTest{
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
  
      /** Converts ordinary function to partial one
 *  @since   2.10
 */
def apply[A, B](f: A => B): PartialFunction[A, B] = { case x => f(x) }

  def main(args: Array[String]): Unit = {
    val rdd1 = sc.parallelize(1 to 9,3)
     println(rdd1.glom.collect.mkString(" & "))
    
     //打印输出二维数组
    for(i <- rdd1.glom.collect) println(i.mkString(" "))
    
    rdd1.foreachPartition(it => {
      while (it.hasNext) {
        println(it.next)
      }
      println("================")
    })
  }
}