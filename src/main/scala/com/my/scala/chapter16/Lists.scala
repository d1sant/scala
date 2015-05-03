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
      case List() => xs
      case x :: xs1 => x :: append(xs1, ys)
    }
}
