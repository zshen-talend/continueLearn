package scalaTest.spark

import org.apache.spark.ml.PipelineModel
import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, Row}
import org.scalatest.FunSuite
import org.talend.dataquality.reconciliation.indexing.TestContext
import org.apache.spark.SparkContext
import org.apache.spark.sql.{SQLContext, SQLImplicits, SparkSession}
import org.apache.spark.sql.types.DoubleType

class CollectTest {
  
}

object CollectTest{
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

    val f: PartialFunction[Int, String] = {
      case 0 => "Sunday"
      case 1 => "Monday"
      case 2 => "Tuesday"
      case 3 => "Wednesday"
      case 4 => "Thursday"
      case 5 => "Friday"
      case 6 => "Saturday"
      case _ => "Unknown"
    }

    val rdd1 = sc.parallelize(0 to 9)
     println(rdd1.collect(f).collect.toList)
    
   
    rdd1.foreachPartition(it => {
      while (it.hasNext) {
        println(it.next)
      }
      println("================")
    })
  }
}