package lectures.part3functionalprogramming

object TuplesAndMaps extends App {

  // tuples are finite ordered "lists"
  val aTuple = (2, "Scala sucks") // Tuple2[Int, String] = (Int, String)

  println(aTuple._1)
  println(aTuple.copy(_2 = "Java"))
  println(aTuple.swap)

  // Maps - Keys -> values
  val aMap: Map[String, Int] = Map()

  val phonebook = Map(("Jim", 555), "Daniel" -> 789).withDefaultValue() // .withDV() returns -1 if no present key->value pair
  // a -> b is sugar for (a, b)
  println(phonebook)

  // map operations
  println(phonebook.contains("Jim"))
  println(phonebook("Mary"))

  // add a pairing
  val newPairing = "Mary" -> 678
  val newPhonebook = phonebook + newPairing
  println(newPhonebook)

  // functionals on maps
  //  map, flatMap, filter
  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  // conversions to other collections
  println(phonebook.toList)
  println(List(("Bob", 555)).toMap)
  val names = List("Bob", "James", "Angela", "Mary")
  println(names.groupBy(name => name.charAt(1)))
}
