package com.my.scala.chapter10

final class LineElement(s: String) extends ArrayElement(Array(s)) {
  override def width = s.length
  override def height = 1
  final override def demo(): Unit = {
    println("LineElement's implementation invoked")
  }
}
