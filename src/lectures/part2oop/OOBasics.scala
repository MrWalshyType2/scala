package lectures.part2oop

object OOBasics extends App {

  val person = new Person("Grognak", 101)
  println(person.x)
  person.greet("Fred")
  person.greet()
}

// class parameters are not class FIELDS (instance variables)
// adding 'val' will make a param a class field
// class constructor
class Person(name: String, val age: Int) {
  // class body defines the implementation of the class (block implementation of a class)

  val x = 2 // this is a field evaluated at instantiation
  println(1 + 3) // this expression is also evaluated at instantiation inside the println statement/side effect

  // this.name is not a class field, but is still referencable inside the class as it is a parameter of the class
  def greet(name: String): Unit = println(s"${this.name} says: Hello $name")

  // Here, 'this' is implied for 'name' as there is no param also called name
  def greet(): Unit = println(s"Hi, I am ${name}") // Overloaded version of greet() with the same name but different signatures

  ////////
  // Overloaded constructors
  def this(name: String) = this(name, 0) // auxillary constructors have to call the primary constructor
  def this() = this("John Doe")
  // Default parameters can also be used with classes
}
