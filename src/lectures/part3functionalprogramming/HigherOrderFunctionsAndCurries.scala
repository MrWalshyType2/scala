package lectures.part3functionalprogramming

object HigherOrderFunctionsAndCurries extends App {

  // why no super function for the function types?
  //val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = ??? // 2 params, Int and Func, returns an Int
  // higher order functions have a function as a parameter

  // func that applies a func n times over a val x
  //  nTimes(f, n, x)
  //  nTimes(f, 3, x) = f(f(f(x))) = nTimes(f, 2, f(x)) = f(f(f(x)))
  //  nTimes(f, n, x) = f(f(...f(x))) = nTimes(f, n-1, f(x))
  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))

  val plusOne = (x: Int) => x + 1

  println(nTimes(plusOne, 10, 1))

  // nTI(f, n) = x => f(f(f...(x)))
  // increment10 = nTI(plusOne, 10) = x => plusOne(plusOne...(x))
  // val y = increment10(1)
  def nTimesImproved(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesImproved(f, n-1)(f(x))

  val plus10 = nTimesImproved(plusOne, 10)
  println(plus10(1))


  // curried functions
  val superAdder: Int => Int => Int = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3) // y => 3 + y
  println(add3(10))
  println(superAdder(3)(10))

  // functions with multiple parameter lists
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))
}
