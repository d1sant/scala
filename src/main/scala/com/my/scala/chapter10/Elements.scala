package com.my.scala.chapter10

object Elements {

  def main(args: Array[String]) {

    // instantiation
    val ae = new ArrayElement(Array("hello", "world"))
    println(ae.width)

    // sub typing 1
    val e1: Element = new ArrayElement(Array("hello"))
    println(e1.width)

    // sub typing 2
    val e2: Element = new LineElement("hi")
    println(e2.width)

    // sub typing 3
    val e3: Element = new UniformElement('x', 2, 3)
    println(e3.width)
  }
}
