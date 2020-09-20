package lectures.part3functionalprogramming

import scala.util.Random

object Sequences extends App {

  val aSequence = Seq(1, 2, 3, 4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5, 7, 6))
  println(aSequence.sorted)

  // ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  (1 to 10).foreach(x => println(x))

  // lists
  val aList = List(1, 2, 3)
  val prepended = 42 :: aList // prepend operator (:: or +:)
  val preAndApend = 0 +: aList :+ 4 // append operator (:+)
  println(prepended)
  println(preAndApend)

  val apples5 = List.fill(5)("apple")
  println(apples5)

  println(aList.mkString("-|-"))

  // arrays are mutable
  val numbers = Array(1, 2, 3, 4)
  val threeElements = Array.ofDim[Int](3) // creates an empty array of 3 elements
  println(threeElements)
  threeElements.foreach(println)

  // mutation
  numbers(2) = 0 // syntax sugar for numbers.update(2, 0)
  println(numbers.mkString(" "))

  // arrays and sequences
  val numbersSeq: Seq[Int] = numbers // implicit conversion
  println(numbersSeq)

  // vectors are immutable sequences
  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector)

  // vectors vs lists
  val maxRuns = 1000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(), 0)
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }
}
