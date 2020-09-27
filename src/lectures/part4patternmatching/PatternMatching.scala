package lectures.part4patternmatching

import scala.util.Random

object PatternMatching extends App {

  // Like a Java switch, but on steds
  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    // case <pattern> => <result>
    case 1 => "ONE"
    case 2 => "TWO"
    case 3 => "THREE"
    case _ => "OTHER" // _ = WILDCARD | Matches anything
  }

  println(x)
  println(description)

  /*
    Pattern Matching can:
      - Decompose values
      - Run guards
      - Give a MatchError if no match is found
      - Have a return type that is unified by the lowest common ancestor (Any if return types String and Int are used togetherz
      - Operate on sealed hierarchies
   */
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)

  // Name and age can be extracted out of 'bob'
  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi, my name is $n and I am younger than 21" // this has a guard
    case Person(n, a) => s"Hi, my name is $n and I am $a years old"
    case _ => "Who am I?"
  }
  println(greeting)

  /*
    Cases are matched in Order
   */

  // Sealed hierarchies
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = new Dog("Min Pin x Frenchie")

  animal match {
    case Dog(someBreed) => println(s"Matched a dog of the $someBreed breed")
    case _ => println("Undetected animal")
  }

  // take an expression, return a human readable form
  trait Expression
  case class Number(n: Int) extends Expression
  case class Sum(e1: Expression, e2: Expression) extends Expression
  case class Prod(e1: Expression, e2: Expression) extends Expression

  val expression1 = Sum(Number(2), Number(3))
  val expression2 = Sum(Sum(Number(2), Number(3)), Number(4))

  def matchExpression(e: Expression): String = {
    e match {
      case Number(n) => s"$n"
      case Sum(e1, e2) => s"${matchExpression(e1)} + ${matchExpression(e2)}"
      case Prod(e1, e2) => {
        def maybeParenthesis(e: Expression) = e match {
          case Prod(_, _) => matchExpression(e)
          case Number(_) => matchExpression(e)
          case _ => "(" + matchExpression(e) + ")"
        }
        maybeParenthesis(e1) + " * " + maybeParenthesis(e2)
      }
    }
  }

  println(matchExpression(expression1))
  println(matchExpression(expression2))
}
