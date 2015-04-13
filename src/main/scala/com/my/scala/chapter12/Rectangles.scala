package com.my.scala.chapter12

object Rectangles {

  def main(args: Array[String]) {

    val rect = new Rectangle(new Point(1, 1), new Point(10, 10))
    println(rect.left)
    println(rect.right)
    println(rect.width)
  }
}
