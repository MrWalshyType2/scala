package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println(s"Computing factorial of $n, I first need the factorial " + (n - 1))
      val result = n * factorial(n - 1)
      println(s"Computed factorial of $n as $result")

      result
    }

  println(factorial(10))
  // println(factorial(5000)) // Causes a StackOverFlowError as its recursive depth is too large

  def anotherFactorial(n: Int): BigInt = {
    @tailrec // tells the compiler the func is meant to be tail recursive
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      // this aux func doesn't need to save the result of its calls to the stack,
      // this is because the accumulator stores the value
      if (x <= 1) accumulator
      else {
        println(s"Computing $x * $accumulator")
        factorialHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression
      }
    }

    factorialHelper(n, 1)
  }

  println(anotherFactorial(10))
//  println(anotherFactorial(5000)) // This works with big numbers


  // WHEN LOOPS ARE NEEDED, USE TAIL RECURSION!

  /*
    USE TAIL RECURSION
    1. Concatenate a string n times
    2. isPrime function
    3. Fibonacci function
   */

  def concatString(s: String, n: Int, sAccumulator: String): String =
    if (n <= 0) sAccumulator
    else concatString(s, n - 1, sAccumulator + s)

  println(concatString("Hello", 5, ""))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def primeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false // if not isStillPrime, evaluate false
      else if (t <= 1) true // if t is less than or equal to 1, evaluate true
      // 'n % t != 0' is if t divides into n and does not equal 0
      else primeTailRec(t - 1, n % t != 0 && isStillPrime)
    }
    primeTailRec(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

  def fibonacci(n: Int): Int = {
    @tailrec
    def fiboTailRec(index: Int, last: Int, nextToLast: Int): Int =
      if (index >= n) last
      else fiboTailRec(index + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboTailRec(2, 1, 1)
  }

  println(fibonacci(13))
}
