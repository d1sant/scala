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
  }

  // constructing lists
  val fruitConst = "apples" :: ("oranges" :: ("pears" :: Nil))
  val numsConst = 1 :: (2 :: (3 :: (4 :: Nil)))
  val diag3Const = (1 :: (0 :: (0 :: Nil))) ::
              (0 :: (1 :: (0 :: Nil))) ::
              (0 :: (0 :: (1 :: Nil))) :: Nil
  val emptyConst = Nil

  // we can drop parentheses
  val numsConst2 = 1 :: 2 :: 3 :: 4 :: Nil
}
