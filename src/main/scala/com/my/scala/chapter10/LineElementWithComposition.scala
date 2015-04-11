package com.my.scala.chapter10

class LineElementWithComposition(s: String) extends Element {
  val contents = Array(s)
  override def width = s.length
  override def height = 1
}
