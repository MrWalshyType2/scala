package lectures.part1basics

object CBNvsCBV extends App {

  // Param is long as Scala time funcs return a num of type Long
  // Exact value of x is computed before assigning to x, which is then used throughout the whole func definition
  def calledByValue(x: Long): Unit = {
    println(s"by value: $x")
    println(s"by value: $x")
  }

  // Expressions are passed literally, not evaluated first when calling by name using the fat-arrow
  def calledByName(x: => Long): Unit = {
    println(s"by name: $x")
    println(s"by name: $x")
  }

  // x = 3483001...
  calledByValue(System.nanoTime())

  // x = System.nanoTime()
  calledByName(System.nanoTime())


  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //  printFirst(infinite(), 34) // stack overflow
  printFirst(34, infinite()) // infinite() does not get evaluated until it is used (which it is not)
}
