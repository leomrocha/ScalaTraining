package leo.training
//Day 2
//Recursion and High orderr Functions


object recursion {

  def main (args: Array[String]): Unit = {
    println("This is a test")
    println( 1 until 5) // Range object that contains 1,2,3,4
    println (1 to 5 ) // Range object that contains 1 2 3 4 5
    val v = factTailRec(6)
  }

  //Exercise 1
  //Write a function for Factorial in an imperative way
  //Write the test for it too under the src/test/scala directory
  def factImp(n: Int ): Int = {
    require (n>=0) //Require imposes a pre-condition to the input parameters, if non compliant will launch an Exception // see tests for examples
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
    require(n>=0)
    n match { //This is the syntax from pattern matching, in this case a really simple pattern
      case x if x < 0 => 0
      case 0 => 1
      case x => x * factRec( x - 1) //This recursion call is NOT a tail call, as there is another operation after the function returns
    }
  }

  //this function is the same as before, but using if-else (to follow better scala better to use pattern matching
  def factRec1(n: Int): Int = {
    require(n >= 0)
    if (n == 0) {
      1
    }
    else {
      n * factRec(n - 1)
    }
  }

  //the following implementation is tail recursive an uses a couple of features to get there
  // the first one is using an internal function, that is the actual recursive one
  // the second is using an acummulator, in this way we can avoid the operation after the recursive call
  // the third is to call with the start status from the function
  //the forth is using the tailrec annotation, which indicates to the compiler that it must check for tail recursion
  // if the function is NOT tail recursive, the compilation will launch an error.
  def factTailRec(n: Int): Int = {
    require(n>=0) //input parameter must be a Natural number
    @annotation.tailrec // tail recursion enforced
    def go(n: Int, acc:Int): Int = //internal helper function that actually defines the recursion
      n match {
        case 0 => 1
        case x => go(x - 1, acc * x) //tail recursive call
      }
    go(n, 1) //initial state of the function
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