import leo.training._

import org.scalatest.FlatSpec

class RecursionSpec extends FlatSpec {

    //TODO make this with test generators or other method, as this way is too repetitive (this can be done in other non copy and paste ways)
  "factImp" should "be 0" in {
    assert(recursion.factImp(0) === 1) //the triple equal === method is given by scalatest, it will print out nthe values that are failing in case of error
  }

  "factImp" should "be 1" in {
    assert(recursion.factImp(1) === 1)
  }
  "factImp" should "be 2" in {
    assert(recursion.factImp(2) === 2)
  }
  "factImp" should "be 6" in {
    assert(recursion.factImp(3) === 6)
  }
  "factImp" should "be 24" in {
    assert(recursion.factImp(4) === 24)
  }
  "factImp" should "be 120" in {
    assert(recursion.factImp(5) === 120)
  }
  "factImp" should "be 720" in {
    assert(recursion.factImp(6) === 720)
  }
  "factImp of a negative number" should "be refused" in {
    try{
      recursion.factImp(-1)
    }
    catch {
      case _:IllegalArgumentException => //Expected
    }
    succeed
  }

  "factRec" should "be 0" in {
    assert(recursion.factRec(0) === 1)
  }
  "factRec" should "be 1" in {
    assert(recursion.factRec(1) === 1)
  }
  "factRec" should "be 2" in {
    assert(recursion.factRec(2) === 2)
  }
  "factRec" should "be 6" in {
    assert(recursion.factRec(3) === 6)
  }
  "factRec" should "be 24" in {
    assert(recursion.factRec(4) === 24)
  }
  "factRec" should "be 120" in {
    assert(recursion.factRec(5) === 120)
  }
  "factRec" should "be 720" in {
    assert(recursion.factRec(6) === 720)
  }
  "factRec of a negative number" should "be refused" in {
    try{
      recursion.factRec(-1)
    }
    catch {
      case _:IllegalArgumentException => //Expected
    }
    succeed
  }
  "factTailRec" should "be 0" in {
    assert(recursion.factTailRec(0) === 1)
  }
  "factTailRec" should "be 1" in {
    assert(recursion.factTailRec(1) === 1)
  }
  "factTailRec" should "be 2" in {
    assert(recursion.factTailRec(2) === 2)
  }
  "factTailRec" should "be 6" in {
    assert(recursion.factTailRec(3) === 6)
  }
  "factTailRec" should "be 24" in {
    assert(recursion.factTailRec(4) === 24)
  }
  "factTailRec" should "be 120" in {
    assert(recursion.factTailRec(5) === 120)
  }
  "factTailRec" should "be 720" in {
    assert(recursion.factTailRec(6) === 720)
  }
  "factTailRec of a negative number" should "be refused" in {
    try{
      recursion.factTailRec(-1)
    }
    catch {
      case _:IllegalArgumentException => //Expected
    }
    succeed
  }


  //TODO Exercise: Make the tests for the Fibonacci implementation
}