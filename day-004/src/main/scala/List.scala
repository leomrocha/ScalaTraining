
/**
  * Created by lrocha on 1/12/17.
  */
// This series of exercises will possibly take longer than one day.
// The idea is to solve them all, We'll implement the DataType List and many operations over it
//
//
//
//Exercise 1: Define and discuss what is a Sealed Trait
// A sealed trait is a trait that can ONLY be used in the same file. This allows the compiler to be able
// to completely see and define all the case classes that use it and give errors if a pattern matching
//does not completely use all the cases

sealed trait List[+A] //Extra Exercise -> Try to understand what the Variance here means, WARNING is not simple (covariance/contravariance)
//Variance means the way a defined object (container) will treat the hierarchy of elements of the contained object
//in this case is covariance, means that: if A parent B, then List[A] parent List[B]

case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  //Exercise define sum of an entire list for Int and Double
  def sum(ints: List[Int]): Int = {
    @annotation.tailrec
    def loop(l:List[Int], acc:Int): Int = {
      l match  {
        case Nil => acc
        case Cons(h, t) => loop(t, acc+h)
      }
    }
    loop(ints, 0)
  }
  //def sum(ds: List[Double]): Double = ???
  //Exercise define for Int and Double the product function
  def product(ints: List[Int]): Int = {
    @annotation.tailrec
    def loop(l:List[Int], acc:Int): Int = {
      l match  {
        case Nil => acc
        case Cons(h, t) => loop(t, acc*h)
      }
    }
    loop(ints, 1)
  }


  //Note that the code is almost the same in both cases, would be better to i
  // implement a more general function for those elements
  // We'll do this later

  //Exercise: Implement function tail, takes a list and returns a list.
  // The returned list contains all but the first element of the input one
  def tail[A](l: List[A]): List[A] = {
    l match {
      case Nil => Nil
      case Cons(_,t) => t
    }
  }

  //Exercise: Implement function that takes a list and an element of type A and returns a list.
  // The returned list is equal to the previous one but for the head that has been replaced for  the given input
  def replaceHead[A](l: List[A], newHead: A): List[A] = {
    l match {
      case Nil => Cons(newHead, Nil)
      case Cons(_,t) => Cons(newHead, t)
    }
  }
  //
  //Exercise: Implement function head, takes a list and returns an Object of type A,
  // being this object the first of the given list.
  //Here the thing is that Option is not yet defined for the book we are following, nevertheless there
  // are not many ways of doing it, maybe returning a list with only one element, but is not nice
  // but for the moment wer are using Option anyways (the book does not)
  def head[A](l: List[A]): Option[A] = {
    l match {
      case Nil => None
      case Cons(h,_) => Some(h) // Cons( h, Nil )
    }
  }
  //

  //Exercise: generalize function tail, takes a list and an integer. Returns a list.
  // The function drops the first n elements from the list
  @annotation.tailrec
  def drop[A](l: List[A], n: Int): List[A] = {
      l match {
        case Nil => Nil
        case Cons(_, t) if n>0 => drop(t, n-1)
        case _ => l
      }
  }

  //Exercise: Implement a function that returns a list of the first n elements of a list
  // The function drops the last elements from the list
  def init[A](l: List[A], n: Int): List[A] = {
    @annotation.tailrec
    def loop(inl: List[A], retl: List[A], n: Int): List[A] ={
      inl match {
        case Nil => retl
        //case Cons(h, t) if n>0 => loop(t, append(retl, h), n-1) //Warning, complexity depends on append function
        case Cons(h, t) if n>0 => loop(t, Cons(h,retl), n-1) //Warning, complexity depends on append function
        case _ => l
      }
    }
    val rev = loop(l, Nil, n)
    reverse(rev)
  }
  //there is another way, is to create a list adding to the head and then reverseing it
  //this is an interesting function to discuss

  //Exercise: generalize function tail, takes a list and an integer. Returns a list.
  // Implement dropWhile , which removes elements from the List prefix as long as they
  // match a predicate.
  //def dropWhile[A](l: List[A], f: A => Boolean): List[A] = ???

  //implementing it as a curried function improves the type inference as the comparison function gives the hint to the compiler
  @annotation.tailrec
  def dropWhile[A](l: List[A])(f: A => Boolean): List[A] = {
      l match {
        case Nil => Nil
        case Cons(h,t) if f(h) => dropWhile(t)(f)
        case _ => l
      }
  }

  def reverse[A](l:List[A]): List[A] = {
    @annotation.tailrec
    def loop(l:List[A], outl:List[A]): List[A] =
      l match {
        case Nil => outl
        case Cons(h,t) => loop(t, Cons(h, outl))
      }
    loop(l, Nil)
  }

  //prepends l1 to l2
  def prepend[A](l1:List[A], l2:List[A]): List[A] = {
    @annotation.tailrec
    def loop(l1:List[A], l2:List[A]):List[A] = l1 match {
      case Nil => l2
      case Cons(h,t) => loop(t, Cons(h,l2))
    }
    //there must be a better way instead of doing a reverse and then the append
    val rev1 = reverse(l1)
    loop(rev1,l2)
  }

  //Exercise: Implement an append function that appends an element to the end of a list
  //
  def append[A](l: List[A], last: A): List[A] = {
    def loop(l: List[A],  f: List[A] => List[A]): List[A] => List[A] = {
      l match {
        case Nil => f
        case Cons(h, t) => {
          val prep = (t:List[A]) => f(Cons(h, t))
          loop(t, prep)
        }
      }
    }
    val res = loop(l, identity )
    res(Cons(last,Nil))
  }

  //Check other ways of doing it ....
  //def append1[A](l: List[A], last: A): List[A] = {
  //  def loop(l: List[A], last:A, f: A => List[A]): A => List[A] = {
  //    l match {
  //      case Nil => f
  //      case Cons(h, t) => {
  //        val prep = (t:List[A]) => f(Cons(h, t))
  //        loop(t, prep)
  //      }
  //    }
  //  }
  //  val res = loop(l, identity )
  //  res(last)
  //}

  //concatenate 2 lists
  //this function has linear complexity with the a1 list length
  def concat0[A](a1: List[A], a2: List[A]): List[A] =
    a1 match {
      case Nil => a2
      case Cons(h,t) => Cons(h, concat0(t, a2))
    }
  //Exercise: Implement an concat function that concatenates two lists
  //this implementation uses another trick, although is a bit more costly in execution time.
  //it will construct the list growing from l2 instead, complexity 2*n with n the length of l
  def concat1[A](l: List[A], l2: List[A]): List[A] = prepend(l,l2)

  //this implementation uses function accumulation instead, returning a function that is actually a composition
  //of several functions
  //the order is n+1 being n the length of the first list
  def concat2[A](l: List[A], l2: List[A]): List[A] = {
    def loop(l1:List[A], acc: List[A] => List[A]):List[A] => List[A] = l1 match {
      case Cons(h, Nil) => (t:List[A]) => acc(Cons(h,t))
      case Cons(h,t) => loop( t, (t:List[A]) =>acc( Cons(h,t) ) )
    }
    val gen = loop(l, identity)
    gen(l2)
  }

  //Exercise: Implement foldRight function
  //Notice that foldRight is NOT tail recursive
  def foldRight[A,B](l: List[A], z:B)(f: (A,B) => B):B = l match {
    case Nil => z
    case Cons(h, t) => f(h, foldRight(t, z)(f))
  }


  //Exercise: Answer: Can product , implemented using foldRight , immediately halt the recursion and
  //return 0.0 if it encounters a 0.0 ? Why or why not? Consider how any short-circuiting
  //might work if you call foldRight with a large list.

  //Exercise: Implement foldLeft
  //def foldLeft[A,B](a: List[A], z: B)(f: (B, A) => B): B = {
  //  def loop(a:List[A], acc:B):B = a match {
  //    case Nil => acc
  //    case Cons(h, t) => loop(t, f(acc,h))
  //  }
  //  loop(a,z)
  //}

  //and now I'll reorganize it to eliminate the inner function and use the foldLeft directly
  @annotation.tailrec
  def foldLeft[A,B](a: List[A], z: B)(f: (B, A) => B): B = a match {
      case Nil => z
      case Cons(h, t) => foldLeft(t, f(z,h))(f)
  }

  //Exercise Implement a function that returns the length of the given list

  def length[A](l: List[A]): Int = {
    def loop(ls:List[A], acc:Int):Int = ls match {
      case Nil => acc
      case Cons(_,t) => loop(t, acc+1)
    }
    loop(l,0)
  }
  //now implementing it with foldRight (or left, should be the same)
  def length[A](l: List[A]): Int = foldRight(l,0)((_,y) => 1+y)

  def lengthfl[A](l: List[A]): Int = foldLeft(l,0)((a,_) => a+1)
  //Exercise: Implement

  //Exercise: Implement sum function with foldLeft
  def sumfr(ls: List[Int]) = foldRight(ls, 0)(_ + _)
  def sumfl(ls: List[Int]) = foldLeft(ls, 0)(_ + _)
  //Exercise: Implement product function with foldLeft
  def productfr(ls: List[Int]) = foldRight(ls, 0)(_ * _)
  def productfl(ls: List[Int]) = foldLeft(ls, 0)(_ * _)

  //Exercise: Implement append function with foldLeft
  //Exercise: Implement concat function with foldLeft

  //Exercise: Implement a function that concatenates an arbitrary number lists into a new list

  //Exercise: Implement the function map that applies a given transformation to every
  // element of a given list and returns a new list
  def map[A,B](as: List[A])(f: A => B): List[B] = ???

  //Exercise: Implement a filter function that returns a new list where the elements are the ones
  // from the input one that satisfy the a given predicate
  def filter[A](as: List[A])(f: A => Boolean): List[A] = ???

  //Exercise: Implement a zip function that takes two lists and returns a list of tuples.
  //

  //Exercise: Implement
  //Returns a list consisting of the first n elements of the list
  def take[A](n: Int): List[A] = ???

  //Exercise: Implement a function thatReturns a list consisting of the longest valid prefix of this whose elements all pass the predicate f
  def takeWhile[A](f: A => Boolean): List[A]  = ???

  //Exercise: Implement a function that Returns true if and only if all elements of this pass the predicate f
  def forall[A](f: A => Boolean): Boolean = ???

  //Exercise: Implement a function that Returns true if any element of this passes the predicate f
  def exists[A](f: A => Boolean): Boolean = ???

  // Exercise: Implement a function that checks whether a list contains a sub-sequence or not
  def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = ???

  //Factory Constructor
  def apply[A](args: A*): List[A] = // Variadic function definition, takes any number of arguments
    if(args.isEmpty) Nil
    else Cons(args.head, apply(args.tail: _*)) // _* does an argument unrolling for passing as varargs

}
