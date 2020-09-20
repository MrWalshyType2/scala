package lectures.part3functionalprogramming

object MapFlatmapFilterFor extends App {

  val list = List(1, 2, 3)
  println(list)

  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_ % 2 == 0))

  // flatMap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')

  val combinations = numbers.flatMap(n => chars.map(c => " " + c + n))
  println(combinations)

  // foreach
  list.foreach(println)

  // for-comprehensions
  val forCombinations = for {
    num <- numbers if num % 2 == 0
    char <- chars
  } yield "" + char + num
  println(forCombinations)

  for {
    num <- numbers
  } println(num)


  // syntax overload
  list.map { x =>
    x * 2
  }
}
