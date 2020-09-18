package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello there"

  // Java funcs available in Scala
  println(str.charAt(2)) // l
  println(str.substring(0, 4)) // Hell
  println(str.split(" ").toList) // List(Hello, there)
  println(str.startsWith("Hello")) // true
  println(str.replace(" ", "-")) // Hello-there
  println(str.toLowerCase()) // hello there
  println(str.length) // 11

  // Scala also has its own String method
  val numString = "2"
  val num = numString.toInt

  // '+:' is prepend and ':+' is append (Scala specific)
  println('a' +: numString :+ 'z') // 45
  println(str.reverse) // .reverse is scala specific
  println(str.take(2)) // he

  // Scala-specific: String interpolators

  //// s-interpolators allow injection of strings via a template-like system
  val name = "David"
  val age = 12
  val greeting = s"Hello my name is $name and I am $age years old"
  val greeting2 = s"Hello my name is $name and I will be turning ${age + 1} years old"
  println(greeting)
  println(greeting2)

  //// f-interpolators act like s-interpolators but can also receive printf like formats
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute" // At least 2 chars and 2 precision
  println(myth)

  // raw-interpolator can print characters literally
  println(raw"This is a \n newline") // the backslash is not escaped
  val escaped = "This is a \n newline"
  println(raw"$escaped") // injected variables are not raw-interpolated
}
