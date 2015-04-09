package com.my.scala.chapter10

/**
 * In order to get rid of parameter with almost the same name in constructor, we introduced parametric field.
 * Previous code is shown below:
 *
 * class ArrayElement(conts: Array[String]) extends Element {
 * val contents: Array[String] = conts
 * }
 *
 */

class ArrayElement(val contents: Array[String]) extends Element {
  override def demo(): Unit = {
    println("ArrayElement's implementation invoked")
  }
}
