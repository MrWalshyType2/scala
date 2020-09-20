package lectures.part2oop

object CaseClasses extends App {

  /*
    equals, hashCode, toString
   */

  case class Person(name: String, age: Int)

  // case class parameters are fields
  val fred = new Person("Fred", 27)
  println(fred.name)

  // case classes have sensible toString output
  println(fred.toString)

  // equals and hashCode implemented out of the box
  val fred2 = new Person("Fred", 27)
  println(fred.equals(fred))

  // case classes have useful copy methods
  val fred3 = fred.copy(age = 28)
  println(fred3)

  // case classes have companion objects
  val thePerson = Person
  val mary = Person("Mary", 32)

  // case classes are serializable

  // case classes have extractor patterns = case classes can be used in PATTERN MATCHING

  // case objects act like case classes, except they are objects
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  println(UnitedKingdom.name)
}
