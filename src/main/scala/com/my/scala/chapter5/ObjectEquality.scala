package com.my.scala.chapter5

object ObjectEquality {

  def main(args: Array[String]) {

    println(1 == 2)
    println(1 != 2)
    println(2 == 2)

    println(List(1, 2, 3) == List(1, 2, 3))
    println(List(1, 2, 3) == List(4, 5, 6))

    println(1 == 1.0)
    println(List(1, 2, 3) == "hello")

    println(List(1, 2, 3) == null)
    println(null == List(1, 2, 3)) // we don't need to check left operand on null. It's build in functionality

    println("he" + "llo" == "hello")
  }
}
