/**
  * Created by lrocha on 09-Jan-17.
  */

//TODO create an object that contains a main method to be able to call it


//Exercise 1:
//Write a function that finds the first occurrence of a letter in the array and returns its position
//signature:
//def findFirst(ss: Array[String], key: String): Int = {}


//Exercise 2:
//Write a function that finds the first occurrence of an object  in the array and returns its position
// The function takes an arbitrary array type and an input comparison test function
//signature:
//def findFirst[A](ss: Array[A], p: A => Boolean): Int = {}


//Exercise 3:
//Write a function that decides if an array of arbitrary data type is sorted or not in a given order
//signature
//def isSorted[A](arr: Array[A], ordered: (A,A) => Boolean : Boolean = {}

//Exercise 4:
// Write a function that converts a function f of two arguments into a function of one argument that partially applies f
//def curry[A,B,C](f: (A,B)=>C): A => (B=>C)

//Exercise 5:
// Write a function that reverts the operation from the previous one
//def uncurry[A,B,C](f: A => B =>C): (A,B) => C

//Exercise 6:
//Function composition
//def compose[A,B,C](f: B =>C, g: A=>B): A => C
