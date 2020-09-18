package lectures.part2oop

import scala.language.postfixOps // required for postfix

object MethodNotations extends App {

  // Declared inside MethodNotations obj as class Person already exists in the package
  // This prevents a conflict
  class Person(val name: String, favouriteMovie: String) {

    def likes(movie: String): Boolean = movie == favouriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the?!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"
  }

  val mary = new Person("Mary", "Jackass")
  val tom = new Person("Tom", "Jackass 2")

  // dot notation
  println(mary.likes("Jackass")) // true

  // infix/operator notation works with methods with one parameter (example of syntactic sugar/nicer way of writing code)
  //  - resembles natural language
  println(mary likes "Jackass") // true

  // "operators" in Scala
  //  - using + as a method name is possible in Scala
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS

  // prefix notation uses urnary operators (also methods)
  val x = -1 // equivalent of 1.unary_-
  val y = 1.unary_-

  // urnary prefix only works with - + ~ !
  println(!mary)
  println(mary.unary_!)

  // postfix notation
  //  funcs without params can be used with postfix notation
  println(mary.isAlive)
  println(mary isAlive) // <- postfix notation (rarely used as can introduce ambiguity)

  // apply
  println(mary.apply())
  println(mary()) // equivalent

  // when a class instance is called like a func, it looks for an 'apply' method on the instantiated obj
}
