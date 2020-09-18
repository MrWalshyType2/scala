package lectures.part1basics

object DefaultArgs extends App {

  // default values means we won't need to create an auxillary function
  def trFactorial(n: Int, acc: Int = 1): Int = {
    if (n <= 1) acc
    else trFactorial(n - 1, n * acc)
  }

  val fact10 = trFactorial(10)
  println(fact10)

  // Passing default parameters can cause issues:
  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println(s"Saving picture in format $format")
  //  savePicture(1080, 720) // will try to set format to 1080

  /*
  Get around this issue by either:
    1. Pass in every leading argument (i.e. 'format' in the savePicture() method)
    2. Name the arguments
   */
  savePicture(height = 720, format = "png")
  savePicture("bmp")
}
