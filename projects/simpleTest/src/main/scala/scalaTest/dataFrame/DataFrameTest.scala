package scalaTest.dataFrame

import org.apache.spark.ml.PipelineModel
import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, Row}
import org.scalatest.FunSuite
import org.talend.dataquality.reconciliation.indexing.TestContext
import org.apache.spark.SparkContext
import org.apache.spark.sql.{SQLContext, SQLImplicits, SparkSession}
import org.apache.spark.sql.types.DoubleType

class DataFrameTest extends FunSuite with TestContext {
  
}



object DataFrameTest  {
   @transient var spark: SparkSession = _
  @transient var sc: SparkContext = _
  spark = SparkSession.builder
      .master("local[2]")
      .appName("IndexingTest")
      .config("spark.sql.shuffle.partitions", "4") // makes small tests much faster
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
  val dfIn: DataFrame = Seq(("GABRIELA", "SUMIKO", "BINGAMAN")).toDF("fName", "middle", "lName")
    dfIn.show()
      val schemaStringRes = Seq("fName", "fName_ref", "middle", "middle_ref", "lName", "lName_ref", "LABEL")
    val fieldsRes = schemaStringRes
      .map(fieldName => StructField(fieldName,  StringType , nullable = true)).:+(StructField("CONFIDENCE_SCORE",  DoubleType , nullable = true))
    val schemaRes = StructType(fieldsRes)
    
    schemaRes.printTreeString()
//DoubleType
  }

 }