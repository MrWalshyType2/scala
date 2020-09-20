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

  def map[B](transformer: MyTransformer[A, B]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]
  def flatMap[B](transformer: MyTransformer[A, B]): MyList[B]

  def ++[B >: A](list: MyList[B]): MyList[B]
}

object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException
  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true
  override def add[B >: Nothing](element: B): MyList[B] = new NList(element, Empty)
  override def printElements: String = ""

  override def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
  override def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
  override def flatMap[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

class NList[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h
  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false
  override def add[B >: A](element: B): MyList[B] = new NList(element, this)
  override def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements

  /*
    [1,2,3].filter(n % 2 == 0) =
      [2,3].filter(n % 2 == 0) =
      = new Cons(2, [3].filter(n % 2 == 0))
      = new Cons(2, Empty.filter(n % 2 == 0))
      = new Cons(2, Empty)

   */
  override def filter(predicate: MyPredicate[A]): MyList[A] =
    if (predicate.test(h)) new NList(h, t.filter(predicate))
    else t.filter(predicate)

  /*
    [1,2,3].map(n * 2)
      = new NList(2, [2, 3].map(n * 2))
      = new NList(2, new NList(4, [3].map(n*2)))
      = new NList(2, new NList(4, new NList(6, Empty.map(n * 2))))
      = new NList(2, new NList(4, new NList(6, Empty))))
   */
  override def map[B](transformer: MyTransformer[A, B]): MyList[B] =
    new NList(transformer.transform(h), t.map(transformer))

  override def flatMap[B](transformer: MyTransformer[A, B]): MyList[B] = ???

  /*
    [1,2] ++ [3,4,5]
    = new NList(1, [2] ++ [3,4,5])

   */
  override def ++[B >: A](list: MyList[B]): MyList[B] = new NList(h, t ++ list)
}

trait MyPredicate[-T] {
  def test(element: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(element: A): B
}

class EvenPredicate extends MyPredicate[Int] {
  override def test(element: Int): Boolean = ???
}

class StringToIntTransformer extends MyTransformer[String, Int] {
  override def transform(element: String): Int = ???
}

object ListTest extends App {
//  val list = new NList(1, new NList(2, new NList(3, Empty)))
//  println(list.tail.tail.head)
//  val list2 = list.add(4)
//  println(list.head) // 1
//  println(list.tail.head)  // 2
//  println(list.tail.tail.head) // 3
//  println(list.toString)
//  println(list2.toString)

  val listOfInts: MyList[Int] = new NList(1, new NList(2, new NList(3, Empty)))
  val listOfStrings: MyList[String] = new NList("Hello", new NList("World", Empty))

  println(listOfInts.toString)
//  println(listOfStrings.toString)

  println(listOfInts.map(new MyTransformer[Int, Int] {
    override def transform(element: Int): Int = element * 2
  }).toString)

  println(listOfInts.filter(new MyPredicate[Int] {
    override def test(element: Int): Boolean = element % 2 == 0
  }).toString)
}
