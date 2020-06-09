package scalaTest

class MethodAndFunction {
  
  
}

object MethodAndFunction{
  def main(args: Array[String]): Unit = {
/*方法和函数的区别?
    0. 答题什么相似,当函数定义在类中,就表示方法,其他的都称为函数
    1. 函数可以作为一个参数传入到方法中,而方法就不行
    2. 在Scala中无法直接操作方法,如果要操作方法,必须先将其转换成函数,
        通常情况下,编译器会自动将方法转换成函数,*/
        val fa = m _;
         println(m(45));
        //表示将m 方法转换为函数
        //在方法名称m后面紧跟一个空格 和下划线 告诉编译器将方法转换成函数,而不是调用这个方法,也可以显示的告诉编译器需要改将这个方法转换成函数
        val f1:(Int)=>Int = m;
        println(f1(45));
        val l1: Seq[Int] => Int = sum1;
        println(l1(Array[Int](1, 2, 3, 45)));
        
    /*3. 函数必须要有参数列表,而方法可以没有参数列表
    4. 在函数出现的地方我么你可以提供一个方法
        在需要函数的地方,如果传递一个方法,会自动进行ETA展开(把方法转换为函数)
        如果我们直接把一个方法赋值给变量会报错,(Missing arguments for method sum1(Int*))
        如若我们指定变量的类型就是函数,name就可以通过编译
        2. 当然我们也可以强制把一个方法转换给函数, m _ 用Scala中的部分应用函数:*/
  }
  
  def sum1(item:Seq[Int]): Int ={
    return item(0)+item(1)+item(2)+item(3);
  }
  def m(item:Int): Int ={
		  return item+1;
  }
}