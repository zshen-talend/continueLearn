package scalaTest

import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.linalg.Vector


object MapTest {
 
  
   def flatMap1(): Unit = {
    val li = List(1,2,3)
    val res = li.flatMap(x => x match {
      case 3 => List('a','b')
      case _ => List(x*2)
    })
    println(res)
  }
 
  def map1(): Unit = {
    val li = Array(1,2,3)
    val res = li.map(x => x match {
      case 3 => List('a','b')
      case _ => x*2
    })
    println(res.toList)
  }
 // The different between flatMap and map
  def main(args: Array[String]): Unit = {
    flatMap1()
    map1()
  }

  
//   private def computeGroupQuality(labelMap: Map[String, Int]) = udf { (prob: Vector, label: String) => {
//    val indexForCurrentLabel = labelMap(label)
//    prob(if (indexForCurrentLabel > 0) indexForCurrentLabel else 0)
//  }
//  }
}