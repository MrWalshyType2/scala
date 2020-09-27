package data_structures

import exercises.MyList

object Lists {

  // +A = Covariant
  abstract class AList[+A] {
    def head: A
    def tail: AList[A]
    def isEmpty: Boolean
    // B is a supertype of A
    def add[B >: A](element: B): AList[B]
    def getElementString: String
    override def toString: String = "["+getElementString+"]"

    def map[B](transformer: A => B): AList[B]
    def flatMap[B](transformer: A => AList[B]): AList[B]
    def filter(predicate: A => Boolean): AList[A]

    def ++[B >: A](list: AList[B]): AList[B]
  }

  case object EmptyList extends AList[Nothing] {
    override def head: Nothing = throw new NoSuchElementException
    override def tail: AList[Nothing] = throw new NoSuchElementException
    override def isEmpty: Boolean = true
    // B is a supertype of Nothing
    override def add[B >: Nothing](element: B): AList[B] = new List(element, EmptyList)
    override def getElementString: String = ""

    override def map[B](transformer: Nothing => B): AList[B] = EmptyList

    override def flatMap[B](transformer: Nothing => AList[B]): AList[B] = EmptyList

    override def filter(predicate: Nothing => Boolean): AList[Nothing] = EmptyList

    override def ++[B >: Nothing](list: AList[B]): AList[B] = list
  }

  case class List[+A](h: A, t: AList[A]) extends AList[A] {
    override def head: A = h
    override def tail: AList[A] = t
    override def isEmpty: Boolean = false
    override def add[B >: A](element: B): AList[B] = new List(element, this)
    override def getElementString: String =
      if (tail.isEmpty) "" + head
      else head + " " + tail.getElementString

    override def map[B](transformer: A => B): AList[B] = {
      new List(transformer.apply(h), t.map(transformer))
    }

    override def flatMap[B](transformer: A => AList[B]): AList[B] = {
      transformer.apply(h) ++ t.flatMap(transformer)
      /*
        [1,2].flatMap(n => [n, n+1])
          [1,2] ++ [2].flatMap(n => [n, n+1])
       */
    }

    override def filter(predicate: A => Boolean): AList[A] = {
      // filter head and tail
      if (predicate.apply(h)) new List(h, t.filter(predicate))
      else t.filter(predicate)

      /*
        USING EvenPredicate with list [2, 53, 3, 4]
        if (h is even) create a List of [h, t.filter(predicate)]
        else t.filter(predicate)

        h = 2, t = 53
        2 is even, new List(2, t.filter(predicate)) [2]
          h = 53, t = 3
          53 is not even, t.filter(predicate)
            h = 3, t = 4
            3 is not even, t.filter(predicate)
              h = 4, t = ?
              4 is even, new List(4, t.filter(predicate)) [2, 4]

       */
    }

    override def ++[B >: A](list: AList[B]): AList[B] = new List(h, t ++ list)
    /*
      [1,2] ++ [3,4,5]
        new List(1, [2] ++ [3,4,5])
          new List(1, new List(2, EmptyList ++ [3,4,5]))
            new List(1, new List(2, new Cons(3, new Cons(4, new Cons(5, EmptyList)))
     */
  }

  class EvenPredicate extends MyPredicate[Int] {
    override def test(t: Int): Boolean = t % 2 == 0
  }

  class StringToIntTransformer extends MyTransformer[String, Int] {
    override def transform(a: String): Int = a.toInt
  }

  trait MyPredicate[-T] {
    def test(t: T): Boolean
  }

  trait MyTransformer[-A, B] {
    def transform(a: A): B
  }

}
