package com.my.scala.chapter10.draft

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

    invokeDome(e1)
    invokeDome(e2)
    invokeDome(e3)
  }

  def invokeDome(e: Element): Unit = {
    e.demo()
  }
}
