package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract classes are defined with the 'abstract' keyword
  abstract class Animal {
    val creatureType: String // abstract field
    def eat(): Unit // abstract method

    // non-abstract method
    def poop(): Unit = println("pooped") // methods with side effects should have parenthesis even if they have no args
  }

  class Dog extends Animal {
    override val creatureType: String = "K9"
    // The compiler can infer if a method is being overridden
    def eat(): Unit = println("Crunch crunch")
  }


  // traits are the Scala version of Java interfaces
  trait Carnivore {
    // non-abstract or concrete member
    val preferredFood: String = "meat, raw"

    // abstract method
    def eat(animal: Animal): Unit
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "amphibian"

    override def eat(): Unit = println("CHOMP")

    override def eat(animal: Animal): Unit = println(s"I'm a crocodile eating a ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)
  croc.poop()

  // traits vs abstract classes
  //  traits do not have constructor parameters
  //  a class can inherit multiple traits, but only inherit (extend) from one class
  //  traits are behaviours, abstract classes are a type of 'thing'
}
