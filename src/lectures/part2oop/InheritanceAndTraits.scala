package lectures.part2oop

object InheritanceAndTraits extends App {
  // Scala ACCESS MODIFIERS: public, private, protected

  // Scala has single class inheritance like other languages
  class Animal {

    val creatureType = "Wild"

    // A protected method can be used within subclasses, but not outside them
//    protected def eat = println("nom nom nom")
    def eat = println("nom nom nom")
  }

  // subclasses inherit all non-private fields and methods of a superclass
  class Cat extends Animal {
    def crunch = {
      eat
      println("catty crunch crunch")
    }
  }

  val cat = new Cat
  // cat.eat // can not use a protected method outside a subclass
  cat.crunch


  // Constructors
  class Person(name: String, age: Int) {

    def this(name: String) = this(name, 0)
  }

  // Extending a class with parameters
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)
  class Child(name: String, age: Int) extends Person(name)

  // overriding
  class Dog(override val creatureType: String) extends Animal {

    // fields can also be overridden in the constructor
    //    override val creatureType: String = "Domestic"
    override def eat = println("doggy crunch, crunch")
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)


  // type substitution (broad sense: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat


  // super
  //  Use to access the supertypes functionality
  class Frog(override val creatureType: String) extends Animal {

    override def eat = {
      super.eat
      println("ribbet")
    }
  }

  val froggy: Frog = new Frog("amphibian")
  froggy.eat


  // Preventing overrides
  //  use the 'final' modifier keyword on member
  //  use 'final' on the class itself
  //  seal the class with the 'sealed' keyword = classes extendible in THIS FILE, not externally
}
