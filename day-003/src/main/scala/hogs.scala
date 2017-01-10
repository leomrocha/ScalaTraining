package leo.training
/**
  * Created by lrocha on 09-Jan-17.
  */

object hogs {


  //TODO create an object that contains a main method to be able to call it
  def main(args: Array[String]) = {
    println ( findFirst(Array("this", "is", "an", "array", "with", "key", "chain"), "key") )

    val ord1 =  isSorted[Int](Array(1,2,3,4,5,6,7,8,9), (a:Int, b:Int) => a < b)
    val ord2 =  isSorted[Int](Array(1,2,3,4,5,10,7,8,9), (a:Int, b:Int) => a < b)

    println("ord1 = " + ord1 + " ord2 = " + ord2)

  }

  //Exercise 1:
  //Write a function that finds the first occurrence of a word in the array and returns its position
  //signature:
  def findFirst(ss: Array[String], key: String): Int = {

    def loop(n:Int): Int = {
      if (n>= ss.length) -1
      else if (ss(n) == key) n
      else loop(n+1)
    }
    loop(0)
  }

  //Exercise 2:
  //Write a function that finds the first occurrence of an object  in the array and returns its position
  // The function takes an arbitrary array type and an input comparison test function
  //signature:
  def findFirst[A](ss: Array[A], p: A => Boolean): Int = {

    def loop(n:Int): Int = {
      if (n>= ss.length) -1
      else if (p(ss(n))) n
      else loop(n+1)
    }
    loop(0)
  }

  //def findFirst[A](ss: Array[A], key:A, p: (A,A) => Boolean): Int = {

  //  def compare(v1: A)(v2: A) = v1 == v2
  //  findFirst(ss, compare(key))
  //}

  //Exercise 3:
  //Write a function that decides if an array of arbitrary data type is sorted or not in a given order
  //signature
  def isSorted[A](arr: Array[A], ordered: (A,A) => Boolean) : Boolean = {

    def isOrd(a: Array[A]): Boolean = {
        a.length match  {
        case x:Int if (x < 2) => true
        case _ => {
          if (!ordered(a(0), a(1))) false
          else isOrd(a.tail)
        }
      }
    }

    isOrd(arr)
  }

  //Exercise 4:
  // Write a function that converts a function f of two arguments into a function of one argument that partially applies f
  //def curry[A,B,C](f: (A,B)=>C): A => (B=>C)

  //Exercise 5:
  // Write a function that reverts the operation from the previous one
  //def uncurry[A,B,C](f: A => B =>C): (A,B) => C

  //Exercise 6:
  //Function composition
  //def compose[A,B,C](f: B =>C, g: A=>B): A => C

}
