package com.my.scala.chapter10

object Elements {

  def main(args: Array[String]) {

    // instantiation
    val ae = new ArrayElement(Array("hello", "world"))
    println(ae.width)

    // subtyping
    val e: Element = new ArrayElement(Array("hello"))
    println(e.width)
  }
}
