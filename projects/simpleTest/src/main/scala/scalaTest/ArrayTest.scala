package scalaTest

// the different foreach and map
object arrayTest extends App{
  var increase=(x:Int)=>x+1
  val someNumbers = List ( -11, -10, - 5, 0, 5, 10)
  var b = someNumbers.foreach(increase)
  println(b.getClass)
  var c = someNumbers.map(increase)
  println(c.getClass)

  c.foreach((x:Int)=>print(x+" "))
  println()
  c.map((x:Int)=>print(x+" "))

}

