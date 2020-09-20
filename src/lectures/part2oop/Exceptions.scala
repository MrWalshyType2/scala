package lectures.part2oop

object Exceptions extends App {

  val x: String = null
//  println(x.length) // Null Pointer Exception

//  throw new NullPointerException // This is an expression

//  val aWeirdValue: String = throw new NullPointerException // Also an expression

  // throwable classes extend 'Throwable'
  //  - Throwable
  //    -- Exception
  //    -- Error

  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("RuntimeException: No int retrieved")
    else 42

  val potentialVal = try {
    getInt(true)
  } catch {
    case re: RuntimeException => re.getMessage
    case npe: NullPointerException => println(npe.getMessage)
  } finally {
    println("Final")
  }

  println(potentialVal)


  class MyException extends  Exception
  val myException = new MyException
  throw myException
}
