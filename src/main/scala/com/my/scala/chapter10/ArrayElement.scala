package com.my.scala.chapter10

/**
 * In Scala it's forbidden to define methods and fields with the same names (in Java it's possible)
 */
class ArrayElement(conts: Array[String]) extends Element {
  val contents: Array[String] = conts
}
