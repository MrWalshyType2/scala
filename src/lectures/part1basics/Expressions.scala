package lectures.part1basics

object Expressions extends App {

  val x = 1 + 45 // KEYWORD NAME = EXPRESSION
  println(x)

  // + - * /
  // / & | ^ << >> >>>
  println(2 + 2 * 5) // MATHEMATICAL EXPRESSION

  // == != > >= < <=
  println(1 == x)

  // ! && ||
  println(!(1 == x))

  var anInt = 5
  anInt += 25
  println(anInt)


  /////////
  // Instructions (DO) vs Expressions (VALUE)

  //  - Instructions are executed (Java)
  //  - Expressions are evaluated (Scala)

  // IF Expression
  val someCondition = true
  val someValue = if(someCondition) 5 else 3 // inline if(<conditional>) <if-true> else <if-false>
  println(someValue)
  println(if(someCondition) 5 else 3)

  // Loops are not recommend in Scala
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // It is bad to write imperatively in Scala,
  // ALMOST EVERYTHING IN SCALA IS AN EXPRESSION
  val someWeirdValue = (i = 3) // Unit === void, is what this evaluates to
  println(someWeirdValue) // Prints '()'

  // side effects: println(), whiles, reassigning

  ////////
  // Code blocks
  //  - A Code block is an expression, its value is the value of its last expression
  val someCodeBlock = {
    val y = 2;
    val z = y + 1;

    if (z > y) "hello" else "bye"
  }
  println(someCodeBlock)

  // A value within a code block cannot be accessed outside its block
  //  println(z)

  // 1. difference between "hello world" vs println("hello world")
  //    - "hello world" is a string literal, println("hello world") is an expression

  // 2. what's the value of
  val someExerciseValue = {
    2 < 3
  }
  //    - someExerciseValue = true

  // and
  val someOtherExerciseValue = {
    if(someExerciseValue) 239 else 986
    42
  }
  //    - someOtherExerciseValue = 42
  println(someOtherExerciseValue)
}
