package lectures.part1basics

// App automatically generates the 'main' method
object ValuesVariablesTypes extends App {

  // 'val' is IMMUTABLE, 'X' is the name, 'Int' is the type, '101' is the value
  val X: Int = 2147483647
  println(X)

  // The Scala compiler (scalac) can also infer types
  val Y = Int.MaxValue
  val Z = -2147483648 // Int.MinValue
  println(Y, Z)

  val aString: String = "hello"
  val bString: String = "bye"

  val aBoolean: Boolean = true
  val aChar: Char = 'A'
  val aShort: Short = 4613
  val aLong: Long = 5849387598432820758L
  val aFloat: Float = 3.14f
  val aDouble: Double = 3.1415

  // Variables are defined with 'var', they are mutable
  var aVariable: Int = 4

  // Variables can be reassigned, variables introduce 'side effects'. Be mindful...
  aVariable = 5
}
