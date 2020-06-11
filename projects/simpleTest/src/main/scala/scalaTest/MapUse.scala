package scalaTest

import scala.collection.mutable
 
/**
  * Map集合的简单使用
  */
object MapUse {
  def main(args: Array[String]): Unit = {
 
    // 创建一个空的map  -- 注意：这里要用实现类，因为Map是抽象类，使用时需要声明具体实现类
    val emptyMap = new mutable.HashMap[String,Int]()
    println(emptyMap) // Map()
 
    // 不可变Map
    val immutableMap = Map("Jim" -> 22, "yxj" -> 32)
    println(immutableMap)
    //immutableMap("yxj") = 33
    // Error:(9, 5) value update is not a member of scala.collection.immutable.Map[String,Int]
    //    immutableMap("yxj") = 33
 
    // 创建可变的map
    val ages = scala.collection.mutable.Map("jim" -> 20, "link" -> 33)
    println(ages)
    // 可以正常修改
    ages("jim") = 30
    println(ages)
 
    // 获取一个key 33
    println(ages("link"))
 
    // 获取不存在的key会报异常 Exception in thread "main" java.util.NoSuchElementException: key not found: yxj
    //println(ages("yxj"))
    // 可以使用contains方法
    val yxj = if(ages.contains("yxj")) ages("yxj") else 0
    println(yxj) // 打印 0
    // 更好的方法是使用函数: getOrElse
    val wll = ages.getOrElse("wulanlan" , 1)
    println(wll) // 打印 1
 
    // 修改 不可变map
    val maps = immutableMap + ("yxj"-> 33)
    println(maps) // 打印 Map(Jim -> 22, yxj -> 33)
 
    val map = immutableMap - "Jim"
    println(map)
 
    // map的遍历，遍历所有的
    for ((key , value) <- ages){
      println(key + ":" + value)
    }
 
    // 遍历key
    for(key <- ages.keySet){
      println("key=" + key)
    }
 
    // 遍历 value
    for( value <- ages.values) {
      println("value=" + value)
    }
  }
 
}