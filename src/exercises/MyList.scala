package exercises

abstract class MyList {

  /*
    Singally linked list
      head = first element of the list
      tail = remainder of the list
      isEmpty = is this lsit empty
      add(int) => new list with this element added
      toString => a string representation of the list
   */
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList {
  override def head: Int = throw new NoSuchElementException

  override def tail: MyList = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add(element: Int): MyList = new NList(element, Empty)

  override def printElements: String = ""
}

class NList(h: Int, t: MyList) extends MyList {
  override def head: Int = h

  override def tail: MyList = t

  override def isEmpty: Boolean = false

  override def add(element: Int): MyList = new NList(element, this)

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
}
