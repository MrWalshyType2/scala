package lectures.part3functionalprogramming

object AnonymousFunctions extends App {

  val double: (Int => Int) = new Function1[Int, Int] {
    override def apply(x: Int): Int = x * 2
  }
  // anonymous function (LAMBDA)
  val doubler: Int => Int = (x: Int) => x * 2
  val doubleCopy: Int => Int = x => x * 2

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  val justDoSomething: () => Int = () => 3

  println(justDoSomething) // this is the function itself
  println(justDoSomething()) // lambdas must be called with params

  // curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MOAR syntactic sugar (underscore notation)
  val incrementer: Int => Int = (x: Int) => x + 1
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1

  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a, b) => a + b
}
