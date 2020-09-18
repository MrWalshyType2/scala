package lectures.part2oop

object Generics extends App {

  // A represents a Generic Type here
  class MyList[+A] {
    // If we add a element other than type A, the list of A turns into a list of the supertype of B
    def add[B >: A](element: B): MyList[B] = ???
    /*
      A = Cat
      B = Dog = Animal
     */
  }

  // Here, Key & Value are generics
  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // Traits can also be type-parametised
  trait SomeTrait[A]

  // generic methods
  object MyList {
    // Returns an empty list of type A
    def empty[A]: MyList[A] = new MyList[A]
  }

  // MyList of type Int
  val emptyListOfInts = MyList.empty[Int]

  // VARIANCE PROBLEM
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // If a Cat extends Animal, does a list of Cat extend a list of Animal?
  //  - Yes, List[Cat] extends List[Animal] = Covariance
  class CovariantList[+A] // Covariant lists have the type prefixed with a +
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat] // Replacing a list of Animal with a List of Cat

  //  - No, List[Animal] extends List[Animal] = Invariance
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal] // Invariant list can only be of the same type

  //  - Hello no! Contravariance
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal] // Replacing a list of Cat with a list of Animal

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal] // A Trainer of Animal can be used as a Trainer of Cat


  // Bounded types allow generic classes to be used for:
  //  - subclass of a different type
  //  - superclasses of a different type
  class Cage[A <: Animal](Animal: A) // Class Cage only allows sub-types of superclass Animal
  val cage = new Cage(new Dog)

  class ScaryCage[A >: Animal](Animal: A) // Class ScaryCage only allows super-types of class Animal

  // bounded types solve a covariance problem
}
