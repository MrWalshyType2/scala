package exercises

// Covariant type A
abstract class MyList[+A] {

  /*
    Singally linked list
      head = first element of the list
      tail = remainder of the list
      isEmpty = is this lsit empty
      add(int) => new list with this element added
      toString => a string representation of the list
   */

  /*
    Expand to be generic
   */

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = new NList(element, Empty)

  override def printElements: String = ""
}

class NList[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): MyList[B] = new NList(element, this)

  override def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
}

object ListTest extends App {
  val list = new NList(1, new NList(2, new NList(3, Empty)))
//  println(list.tail.tail.head)
  val list2 = list.add(4)
  println(list.head) // 1
  println(list.tail.head)  // 2
  println(list.tail.tail.head) // 3
  println(list.toString)
  println(list2.toString)

  val listOfInts: MyList[Int] = new NList(1, new NList(2, new NList(3, Empty)))
  val listOfStrings: MyList[String] = new NList("Hello", new NList("World", Empty))

  println(listOfInts.toString)
  println(listOfStrings.toString)
}
