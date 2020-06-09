package scalaTest

import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.linalg.Vector


object MapTest {
  def main(args: Array[String]):Unit={
    
  }
  
//   private def computeGroupQuality(labelMap: Map[String, Int]) = udf { (prob: Vector, label: String) => {
//    val indexForCurrentLabel = labelMap(label)
//    prob(if (indexForCurrentLabel > 0) indexForCurrentLabel else 0)
//  }
//  }
}