package lectures.part1basics

object Functions extends App {

  // 'def' is the function keyword

  // def <name>(<param-name>: <param-type>): <return-type>
  def aFunction(a: String, b: Int): String = {
    a + " " + b // String concatenation
  }

  println(aFunction("Hello K", 10))

  // A function with no parameters can be called without parameters
  def aParameterLessFunction(): Int = 42
  println(aParameterLessFunction())
  println(aParameterLessFunction)

  // looping in a functional language is different, it is done recursively via RECURSION
  def aRepeatedFunction(aString: String, n: Int): String = {
    // if n is equal to 1, return the value of aString
    if (n == 1) aString
    // else, return aString + the value of aRepeatedFunction
    // with the value of parameter aString and parameter n - 1
    else aString + aRepeatedFunction(aString, n-1)
  }
  println(aRepeatedFunction("Hello", 5))

  // In Scala, LOOP VIA RECURSION
  /////////////

  /////////////
  // scalac infers the return type of standard functions,
  // THIS DOES NOT APPLY TO RECURSIVE FUNCTIONS
  def bFunction(a: String, b: Int) = {
    a + " " + b
  }

  // Functions that have side effects are usually needed with functions not used in computation
  def aFuncWithSideEffects(aString: String): Unit = println(aString)

  // Code blocks can define auxiliary functions inside them as well as blocks
  def aBigFunc(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }
  println(aBigFunc(10))

  /*
    1. A greeting function (name, age) => "Hi, my is $name and I am $age years old."
    2. A factorial function 1 * 2 * 3 * .. * n, all the way up to n
    3. A fibonacci function
        f(1) = 1
        f(2) = 1
        f(n) = f(n - 1) + f(n - 2)
    4. Tests if a number is prime
   */

  // 's' String Interpolator: https://docs.scala-lang.org/overviews/core/string-interpolation.html
  val greeting = (name: String, age: Int) => s"Hi, my name is $name and I am $age years old."
  println(greeting("Bob", 34))

  def factorial(n: Int): Long =
    if (n <= 1) 1
    else n * factorial(n - 1)

  val facto = factorial(12)
  println(s"Factorial of 12 is $facto")

  def fibonacci(n: Int): Long =
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)

  val fibo = fibonacci(14)
  println(s"Fibonacci number of 14 is $fibo")

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1) // recursive calls to check no num t divides into num n

    isPrimeUntil(n / 2)
  }

  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(5 * 2))
}
