package playground

import scala.util.Random

object ScalaPlayground extends App {

  println("Hello Scala!")

  val strConcat = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  val strConcatSugar = new ((String, String) => String) {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

//  println(strConcat("Hello", " World"))

  val plusOne = (x: Int) => x + 1

  def nTimes(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimes(f, n - 1)(f(x))

  val add20 = nTimes(plusOne, 20)

  val add20manual = (x: Int) => nTimes(plusOne, 20 - 1)(plusOne(x))
  /*
    add20(x) == (x: Int) => nTimes(plusOne, 20 - 1)(plusOne(x))

    add20(5) == (5: Int) => nTimes(plusOne, 20 - 1)(plusOne(5))
    x = 6
      add20(6) == (6: Int) => nTimes(plusOne, 19 - 1)(plusOne(6))
      x = 7
        add20(7) == (7: Int) => nTimes(plusOne, 18 - 1)(plusOne(7))
        x = 8
          add20(8) == (8: Int) => nTimes(plusOne, 17 - 1)(plusOne(8))
          x = 9
     ------------------------------------------------------------------
     add3(x) == (x: Int) => nTimes(plusOne, 3 - 1)(plusOne(x))

     add3(3) == (3: Int) => nTimes(plusOne, 3 - 1)(plusOne(3))
     x = 4
      add3(4) == (3: Int) => nTimes(plusOne, 2 - 1)(plusOne(4))
      x = 5
        add3(5) == (3: Int) => nTimes(plusOne, 1 - 1)(plusOne(5))
        x = 6
   */

  // Currying
  println("Currying")

  // note the multi-parameter list
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  // x = input to standardFormat, c = input to curriedFormatter
  def standardFormat: (Double => String) = curriedFormatter("%4.2f")

//  println(standardFormat(37.3243423)) // 37.32

//  println(curriedFormatter("%4.2f")(37.3243423)) // Can use a func to call curriedFormatter or directly call the curriedFormatter with two param lists

  val nums = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')

  def combine: (String, Int) => List[String] = (s: String, n: Int) => List(s + n)
  def combine2: (String, Int) => String = (s: String, n: Int) => s + n

  val combined = nums.flatMap(n => chars.flatMap(c => combine(c.toString, n)))
  val combined2 = nums.flatMap(n => chars.map(c => combine2(c.toString, n)))
  val combinations = nums.flatMap(n => chars.map(c => "" + c + n))

//  println(combinations)
//  println(combined)
//  println(combined2)

  val forComprehensions = for {
    n <- nums if n % 2 == 0 // translated into a filter call
    c <- chars
  } yield c.toString + n

  print(forComprehensions)

  for {
    n <- nums
  } println(n)

  // syntax overload
  nums.map { x =>
    x * 2
  }

  println("Options")
  // Options
  val config: Map[String, String] = Map(
    // values fetched from somewhere else, no certainty they have values inside the map
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected"
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  val host = config.get("host")
  val port = config.get("port")

  /*
    if (h != null)
      if (p != nulll)
        return Connection.apply(h, p)
    return null
   */
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))

  /*
    if (c != null)
      return c.connect
    return null
   */
  val connectionStatus = connection.map(c => c.connect)

  /*
    if (status != null)
      println(status
   */
  connectionStatus.foreach(println)
//  println(connectionStatus)

  // Chained calls
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port))
      .map(connection => connection.connect))
    .foreach(println)

  // for-comprehensions
  println("Optional for-comprehension")
  val connectionStatus2 = for {
    host <- config.get("host") // given a host
    port <- config.get("port") // and given a port
    connection <- Connection(host, port) // and given a Connection with host and port
  } yield connection.connect // return the connection
  connectionStatus2.foreach(println)
}
