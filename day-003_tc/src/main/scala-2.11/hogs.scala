/**
  * Created by lrocha on 09-Jan-17.
  */

package exercice.day3

import scala.util.Try

//TODO create an object that contains a main method to be able to call it
object hogs {

  def main(args: Array[String]): Unit = {
    println("I am hogs main")
  }



  //Exercise 1:
  //Write a function that finds the first occurrence of a word in the array and returns its position
  //signature:
  def findFirst(ss: Array[String], word: String): Int = {
    def myFind(a: String,b: String): Boolean = {
      a.contains(b)
    }

    Try(ss.zipWithIndex.filter{ case (s,id) => myFind(s,word) }(0)._2)getOrElse(-1)
  }


  //Exercise 2:
  //Write a function that finds the first occurrence of an object  in the array and returns its position
  // The function takes an arbitrary array type and an input comparison test function
  //signature:
  def findFirst[A](ss: Array[A], p: A => Boolean): Int = {

    //Try(ss.zipWithIndex.filter{ case (s,id) => p(s) }(0)._2)getOrElse(-1)
    ss.zipWithIndex.filter{ case (s,id) => p(s) }.headOption.getOrElse(-1)
  }


  //Exercise 3:
  //Write a function that decides if an array of arbitrary data type is sorted or not in a given order
  //signature
  def isSorted[A](arr: Array[A], ordered: (A,A) => Boolean ): Boolean = {
    for(x <- arr.sliding(2)) if(!ordered(x(0), x(1))) return false
    true
  }

  //Exercise 4:
  // Write a function that converts a function f of two arguments into a function of one argument that partially applies f
  def curry[A,B,C](f: (A,B)=>C): A => (B=>C) = a => b => f(a,b)

  //Exercise 5:
  // Write a function that reverts the operation from the previous one
  def uncurry[A,B,C](f: A => B =>C): (A,B) => C = (a,b) => f(a)(b)

  //Exercise 6:
  //Function composition
  def compose[A,B,C](f: B =>C, g: A=>B): A => C = {
    a => f(g(a))
  }
}
