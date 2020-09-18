package exercises

import java.time.Year

object OOBasics extends App {

  /*
    Novel and a Writer
      Writer: first name, surname, year
        - method fullName
      Novel: name, year of release, author
        - authorAge
        - isWrittenBy(author)
        - copy (new year of release) = new instance of Novel with new year of release
   */
  val fred = new Writer("Fred", "Jenkins", 1990)
  val imposter = new Writer("Fred", "Jenkins", 1990)
  println(fred.fullName())

  val fredsNovel = new Novel("Fred's Adventure", 2013, fred)
  println(s"${fred.fullName()} is ${fredsNovel.authorAge()} years old")
  println(s"Did ${fred.fullName()} write Fred's Adventure: ${fredsNovel.isWrittenBy(fred)}")
  println(s"Did imposter ${imposter.fullName()} write Fred's Adventure: ${fredsNovel.isWrittenBy(imposter)}")

  /*
    Counter class
      - receives an int value
      - method currentCount
      - method to increment/decrement => new counter
      - overload increment/decrement to receive an amount
   */
  var c = new Counter(1)
  println(c.currentCount()) // 1
  println(c.increment().currentCount()) // 2
  println(c.increment(3).currentCount()) // 4
  println(c.decrement(4).currentCount()) // -3
}

class Writer(forename: String, surname: String, val yearOfBirth: Int) {

  val fullName = () => s"$forename $surname"
}

class Novel(name: String, releaseYear: Int, author: Writer) {

  val authorAge = () => Year.now.getValue - author.yearOfBirth
  val isWrittenBy = (author: Writer) => this.author.equals(author)

  def copy(releaseYear: Int): Novel = new Novel(name, releaseYear, author)
}

class Counter(count: Int) {
  // In functional programming, when modifying an instance you need to return a new instance rather than modify
  // the current instance

  val currentCount = () => count

  def increment(): Counter = new Counter(count + 1)
  def increment(amount: Int): Counter = new Counter(count + amount)
  def incRecursively(amount: Int): Counter = if (amount <= 0) this else increment.incRecursively(amount - 1)

  def decrement(): Counter = new Counter(count - 1)
  def decrement(amount: Int): Counter = new Counter(count - amount)
  def decRecursively(amount: Int): Counter = if (amount <= 0) this else decrement.decRecursively(amount - 1)
}
