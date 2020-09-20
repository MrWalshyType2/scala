package lectures.part3functionalprogramming

object WhatsAFunction extends App {

  // DREAM: use functions as first class elements
  // problem: OOP

  // Creating a func that takes an Int (element) and returns an Int (element * 2)
  val double = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }
  println(double(5))


  // function types = Function1[A,B]  <- Supported by default in Scala
  val stringToIntConverter = new Function[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }
  println(stringToIntConverter("7"))

  // Function2[A, B, R] === (A,B) => R (result)
  val adder: Function2[Int, Int, Int] = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // With syntactic sugar
  val adder2: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }
  println(adder2(10, 10))
}

// Java OOP style
class Action {
  def execute(element: Int): String = ???
}

// Scala style - generics
trait MyFunction[A, B] {
  // Takes in type A and returns type B
  def apply(element: A): B
}
