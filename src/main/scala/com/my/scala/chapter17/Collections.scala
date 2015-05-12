package com.my.scala.chapter17

object Collections {

  def main(args: Array[String]) {

    // Sequences
    // Lists:
    val colors = List("red", "blue", "green")
    println(colors)
    println(colors.head)
    println(colors.tail)

    // Arrays:
    val fiveInts = new Array[Int](5)
    println(fiveInts.mkString(" ,"))

    val fiveToOne = Array(5, 4, 3, 2, 1)
    println(fiveToOne.mkString(" ,"))

    fiveInts(0) = fiveToOne(4)
    println(fiveInts.mkString(" ,"))
  }
}
