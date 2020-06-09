package scalaTest.spark

import org.apache.spark.sql.types._
  /**
      * 一个scheme是
      */
import org.apache.spark.sql.types.StructType

class StructorFileTest {
  
}

 
 
/**
  * Created by root on 9/21/16.
  */
object StructorFileTest {
  //--------------------------------------------------StructType analysis---------------------------------------
  val struct = StructType(
    StructField("a", IntegerType) ::
      StructField("b", LongType, false) ::
      StructField("c", BooleanType, false) :: Nil)
 
  def schema_StructType()={
  
    val schemaTyped = new StructType()
      .add("a","int").add("b","string")
    schemaTyped.foreach(println)
    /**
      * StructField(a,IntegerType,true)
      * StructField(b,StringType,true)
      */
  }
  def structType_extracted()={
 
    // Extract a single StructField.
    val singleField_a = struct("a")
    println(singleField_a)
    //省却的清空下表示：可以为空的，
    //StructField(a,IntegerType,true)
    val singleField_b = struct("b")
    println(singleField_b)
    //StructField(b,LongType,false)
 
    //val nonExisting = struct("d")
    //println(nonExisting)
    //java.lang.IllegalArgumentException: Field "d" does not exist.
 
    // Extract multiple StructFields. Field names are provided in a set.
    // A StructType object will be returned.
    val twoFields = struct(Set("b", "c"))
    println(twoFields)
 
 
    //StructType(StructField(b,LongType,false), StructField(c,BooleanType,false))
    // Any names without matching fields will be ignored.
    // For the case shown below, "d" will be ignored and
    // it is treated as struct(Set("b", "c")).
    val ignoreNonExisting = struct(Set("b", "c", "d"))
    println(ignoreNonExisting)
    // ignoreNonExisting: StructType =
    //   StructType(List(StructField(b,LongType,false), StructField(c,BooleanType,false)))
 
    //值得注意的是：当没有存在的字段的时候，官方文档说：单个返回的是null，多个返回的是当没有那个字段
    //但是实验的时候，报错---Field d does not exist
    //源码调用的是apply方法，确实还没有处理好这部分功能
    //我是用的是spark2.0初始版本
 
  }
  def structType_opration()={
 
    /**
      * 源码：case class StructType(fields: Array[StructField]) extends DataType with Seq[StructField] {
      * 它是继承与Seq的，也就是说 Seq的操作，StructType都有
      * 可以查看scala的Seq的操作:http://www.scala-lang.org/api/current/#scala.collection.Seq
      */
    val tmpStruct = StructType(StructField("d", IntegerType)::Nil)
    //集合与集合的操作
    println(struct++tmpStruct)
    // println(struct++:tmpStruct)
    //List(StructField(a,IntegerType,true), StructField(b,LongType,false), StructField(c,BooleanType,false), StructField(d,IntegerType,true))
 
    //集合与元素的操作
    println(struct :+ StructField("d", IntegerType))
 
    //可以用add来进行
 
    println(struct.add("e",IntegerType))
    //StructType(StructField(a,IntegerType,true), StructField(b,LongType,false), StructField(c,BooleanType,false), StructField(e,IntegerType,true))
 
    //head 部分的元素
    println(struct.head)
    //StructField(a,IntegerType,true)
 
 
    //last 部分的元素
    println(struct.last)
    //StructField(c,BooleanType,false)
 
    println(struct.apply("a"))
    //StructField(a,IntegerType,true)
 
    println(struct.treeString)
 
    /**
      * root
       |-- a: integer (nullable = true)
       |-- b: long (nullable = false)
       |-- c: boolean (nullable = false)
      */
 
    println(struct.contains(StructField("f", IntegerType)))
    //false
 
    println(struct.mkString)
    //StructField(a,IntegerType,true)StructField(b,LongType,false)StructField(c,BooleanType,false)
 
    println(struct.prettyJson)
 
    /**
      * {
          "type" : "struct",
          "fields" : [ {
            "name" : "a",
            "type" : "integer",
            "nullable" : true,
            "metadata" : { }
          }, {
            "name" : "b",
            "type" : "long",
            "nullable" : false,
            "metadata" : { }
          }, {
            "name" : "c",
            "type" : "boolean",
            "nullable" : false,
            "metadata" : { }
          } ]
        }
      */
    //更多操作可以查看API：http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.sql.types.StructType
  }
 
 
 
  def main(args: Array[String]) {
    //schema_StructType()
    //structType_extracted()
    structType_opration()
  }
}
