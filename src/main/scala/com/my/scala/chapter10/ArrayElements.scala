package com.my.scala.chapter10

object ArrayElements {

  def main(args: Array[String]) {

    // instantiation
    val ae = new ArrayElement(Array("hello", "world"))
    println(ae.width)

    // subtyping
    val e: Element = new ArrayElement(Array("hello"))
  }
}
