package lectures.part3functionalprogramming

import scala.util.{Try, Failure, Success}

object HandlingFailure extends App {

  // create success and failure
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("Failed"))

  println(aSuccess)
  println(aFailure)

  // Don't need to construct Success and Failure most of the time, the Try companions objects apply method does this
  def unsafeMethod(): String = throw new RuntimeException("No string hahahahahaha")

  // Try objects via 'apply'
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  // Syntax sugar
  val anotherPotentialFailure = Try {
    // code that might throw
  }

  // utilities
  println(potentialFailure.isSuccess) // false

  // orElse
  def backupMethod(): String = "A valid result"
  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))
  println(fallbackTry.getOrElse(None))

  // IF DESIGNING AN API
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)
  def betterBackupMethod(): Try[String] = Success("A valid result 2")
  val betterFallback = betterUnsafeMethod() orElse betterBackupMethod()
  println(betterFallback.getOrElse(None))

  // map, flatMap, filter
  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(_ > 10))
}
