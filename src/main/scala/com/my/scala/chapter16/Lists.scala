package com.my.scala.chapter16

object Lists {

  def main(args: Array[String]) {

    // Lists are immutable and can't be changed by assignment
    val fruit = List("apples", "oranges", "pears")
    val nums = List(1, 2, 3, 4)
    val diag3 =
      List(
        List(1, 0, 0),
        List(0, 1, 0),
        List(0, 0, 1)
      )
    val empty = List()

    val fruitTyped: List[String] = List("apples", "oranges", "pears")
    val numsTyped: List[Int] = List(1, 2, 3, 4)
    val diag3Typed: List[List[Int]] =
      List(
        List(1, 0, 0),
        List(0, 1, 0),
        List(0, 0, 1)
      )
    val emptyTyped: List[Nothing] = List()

    // List() is also type of List[String]!
    val vs: List[String] = List()

    // constructing lists
    val fruitConst = "apples" :: ("oranges" :: ("pears" :: Nil))
    val numsConst = 1 :: (2 :: (3 :: (4 :: Nil)))
    val diag3Const = (1 :: (0 :: (0 :: Nil))) ::
      (0 :: (1 :: (0 :: Nil))) ::
      (0 :: (0 :: (1 :: Nil))) :: Nil
    val emptyConst = Nil

    // we can drop parentheses
    val numsConst2 = 1 :: 2 :: 3 :: 4 :: Nil

    // Nil.head // will throw noSuchElementException

    val unsorted = List(5, 2, 7, 1, 3, 10, 4)
    println(isort(unsorted))

    // pattern matching using lists
    val List(a, b, c) = fruit
    println(a)
    println(b)
    println(c)

    val d :: e :: rest = fruit
    println(d)
    println(e)
    println(rest)

    val unsorted2 = List(5, 2, 7, 1, 3, 10, 4)
    println(isort(unsorted2))

    // concatenating two lists
    println(List(1, 2) ::: List(3, 4, 5, 6))
    println(List() ::: List(1, 2, 3))
    println(List(1, 2, 3, 4) ::: List(5))

    // xs ::: ys ::: zs will interpret as xs ::: (ys ::: zs)

    println(append(List(1, 2), List(3, 4, 5)))

    // List().length == 0 is quite expensive operation comparing to isEmpty if you need to check on emptiness
    println(List(1, 2, 3).length)

    val abcde = List('a', 'b', 'c', 'd', 'e')
    println(abcde.head)
    println(abcde.tail)
    println(abcde.last)
    println(abcde.init)

    // List().init will throw an exception
    // List().last will throw an exception

    println(abcde.reverse) // will produce new reversed list
    println(abcde) // the initial won't be changed cause lists are immutable

    /**
     * a) reverse is its own inverse:
     * xs.reverse.reverse equals xs
     *
     * b) reverse turns init to tail and last to head, except that the ele- ments are reversed:
     * xs.reverse.init equals xs.tail.reverse
     * xs.reverse.tail equals xs.init.reverse
     * xs.reverse.head equals xs.last
     * xs.reverse.last equals xs.head
     */

    println(abcde take 2)
    println(abcde drop 2)
    println(abcde splitAt 2)

    println(abcde apply 2) // rare in scala comparing to array
    println(abcde(2)) // rare in scala comparing to array

    // xs apply n equals (xs drop n).head

    println(abcde.indices)
  }

  /**
   * Insertion sort algorithm
   */
  def isort(xs: List[Int]): List[Int] =
    if (xs.isEmpty) Nil
    else insert(xs.head, isort(xs.tail))

  def insert(x: Int, xs: List[Int]): List[Int] =
    if (xs.isEmpty || x <= xs.head) x :: xs
    else xs.head :: insert(x, xs.tail)

  /**
   * Insertion sort algorithm rewritten using class matching
   */
  def isort2(xs: List[Int]): List[Int] = xs match {
    case List() => Nil
    case x :: xs1 => insert2(x, isort2(xs1) )
  }

  def insert2(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x <= y) x :: xs
                    else y :: insert2(x, ys)
  }

  def append[T](xs: List[T], ys: List[T]): List[T] =
    xs match {
      case List() => ys
      case x :: xs1 => x :: append(xs1, ys)
    }

  def rev[T](xs: List[T]): List[T] = xs match {
    case List() => xs
    case x :: xs1 => rev(xs1) ::: List(x)
  }
}
