package leo.training
//Day 2
//Recursion and High orderr Functions


object recursion {

  def main (args: Array[String]): Unit = {
    println("This is a test")
    println( 1 until 5) // 1,2,3,4
    println (1 to 5 ) // 1 2 3 4 5
    val v = factTailRec(6)
  }

  //Exercise 1
  //Write a function for Factorial in an imperative way
  //Write the test for it too under the src/test/scala directory
  def factImp(n: Int ): Int = {
    require (n>=0)
    var fact = 1
    for (i <- 1 to n){
      fact = fact * i
    }
    fact
  }

  //Exercise 2.a
  //Write a function for Factorial in a recursive way, try to make it tail recursive
  //Write the test for it too under the src/test/scala directory
  def factRec(n: Int): Int = {
    //require(n>=0)
    n match {
      case x if x < 0 => 0
      case 0 => 1
      case x => x * factRec( x - 1)
    }
  }

  def factRec1(n: Int): Int = {
    require(n >= 0)
    if (n == 0) {
      1
    }
    else {
      n * factRec(n - 1)
    }
  }

    def factTailRec(n: Int): Int = {
      require(n>=0)
      @annotation.tailrec
      def go(n: Int, acc:Int): Int =
        n match {
          case 0 => 1
          case x => go(x - 1, acc * x)
        }
      go(n, 1)
    }
  //Exercise 3
  //Write a Fibonacci function in an imperative way
  //The function must find the Nth Fibonacci Element
  //Write the test for it too under the src/test/scala directory

  def fibImp(n: Int): Int = {
    ???
  }
  //Exercise 4
  //Write a Fibonacci function in a recursive way, try to make it tail recursive
  //Write the test for it too under the src/test/scala directory
  def fibRec(n: Int): Int = {
    ???
  }
}