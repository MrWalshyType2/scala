package data_structures

import data_structures.Lists.{EmptyList, EvenPredicate, StringToIntTransformer}

object Runner extends App {

  val myList: Lists.AList[Int] = new Lists.List(20, Lists.EmptyList)
  println(myList.head)

  val myList2 = myList.add(32)
  val myList3 = myList2.add(593)
  println(myList2.head)
  println(myList3.head, myList3.tail.head, myList3.tail.tail.head)

  println(myList3.toString)

  val myListIntAndString = myList3.add("Hello") // Adding a String to a list of Int makes the list of type Any
  println(myListIntAndString.toString)

//  println(myList3.filter(new Function1[Int, Int] {
//    override def apply(v1: Int): Int = v1 * 2
//  }))


  ///////////////////////////////////////
//  val listOfString = new Lists.List("1", new Lists.List("2", new Lists.List("3", new Lists.List("4", EmptyList))))
//  println(listOfString.toString)

//  val anotherList = listOfString.map(new StringToIntTransformer)
//  println(anotherList)
}
