package lectures.part2oop

object AnonymousClasses extends App {

  // can also be a trait
  abstract class Animal{
    def eat: Unit
  }

  // anonymous class created from evaluation of the right side of the expression
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahaha")
  }

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }

  // Normal rules apply here, parameters have to be passed
  val abe = new Person("Abe") {
    override def sayHi: Unit = super.sayHi
  }
}
