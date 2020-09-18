package exercises

import scala.language.postfixOps

object MethodNotations extends App {

  /*
    1. Overload the + operater
        mary + "the rockstar" => new Person "Mary (the rockstar)"

    2. Add an age to the Person class with default 0 val
        add a unary + operator => new Person with the age + 1
          +mary => mary with the age prefix

    3. Add a "learns" method in the Person class => "Mary learns Scala"
        add a learnsScala method with no params that calls the learns method with "Scala"
          Use it in postfix notation

    4. Overload the apply method
        mary.apply(2) => "Mary watched $favouriteMovie 2 times
   */
  class Person(val name: String, val age: Int = 0, favouriteMovie: String) {

    def likes(movie: String): Boolean = movie == favouriteMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(title: String): String = s"$name ($title)"

    def unary_! : String = s"$name, what the?!"
    def unary_+ : Person = new Person(name, age + 1, favouriteMovie)

    def isAlive: Boolean = true

    def learns(subject: String): String = s"$name learns $subject"
    def learnsScala: String = learns("Scala")

    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"
    def apply(n: Int): String = s"$name watched $favouriteMovie $n times"
  }

  val mary = new Person("Mary", 32, "Jackass")
  val tom = new Person("Tom", 29, "Jackass 2")

  println(mary + "The Rockstar")
  println((+mary).age) // urnary_+ prefix
  println(mary learns "Java") // infix
  println(mary learnsScala) // post fix
  println(mary(33)) // apply method
}
