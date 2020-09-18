package lectures.part2oop

object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY (i.e. "static" in Java)

  object Person { // type = Person, this is an instance of the 'Person' type

    // Scala implements class-level (static) functionality via objects
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) {
    // The instance-level functionality resides inside a class
    //  object Person & class Person are companions
  }

  println(Person.N_EYES) // 2
  println(Person.canFly) // false

  // A Scala object is a SINGLETON INSTANCE
  val mary = Person
  val john = Person
  println(mary == john) // true as mary and john point at the same instance

  // An instantiated Person class is not a singleton instance like the Person object
  val nicky = new Person("Nicky")
  val bob = new Person("Bob")
  val bobbie = Person(nicky, bob)

  // Scala Applications = Scala object with
  //  def main(args: Array[String]): Unit
}
