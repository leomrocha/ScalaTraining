import exercice.day3._

import org.scalatest._

class HogsSpec extends FlatSpec with Matchers{
  "hogs findFirst with [hello,world] hello" should "be 0" in {
    val inputArray = Array("hello","world")
    val res = hogs.findFirst(inputArray, "hello")
    res should be (0)
  }

  "hogs findFirst with [hello,world] no" should "be -1" in {
    val inputArray = Array("hello","world")
    val res = hogs.findFirst(inputArray, "no")
    res should be (-1)
  }


  "hogs findFirst with [hello,world, hello] hello" should "be 0" in {
    val inputArray = Array("hello","world", "hello")
    val res = hogs.findFirst(inputArray, "hello")
    res should be (0)
  }

  "hogs findFirst with [hello,world] find(hello)" should "be 0" in {
    val inputArray = Array("hello","world")
    val myFind = (s: String) => { s.contains("hello")}
    val res = hogs.findFirst(inputArray, myFind)
    res should be (0)
  }


  "hogs findFirst with [10,11,12,15,17] find(12)" should "be 2" in {
    val inputArray = Array(10,11,12,15,17)
    val myFind = (i: Int) => { i == 12}
    val res = hogs.findFirst(inputArray, myFind)
    res should be (2)
  }

  "hogs issortedt with [10,11,12,15,17] inferior" should "be true" in {
    val inputArray = Array(10,11,12,15,17)
    val inf = (a: Int, b: Int) => { a < b}
    val res = hogs.isSorted(inputArray, inf)
    res should be (true)
  }

    "hogs issortedt with [10,13,12,15,17] inferior" should "be false" in {
    val inputArray = Array(10,13,12,15,17)
    val inf = (a: Int, b: Int) => { a < b}
    val res = hogs.isSorted(inputArray, inf)
    res should be (false)
  }


}
