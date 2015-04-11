package com.my.scala.chapter10

import Element.elem

object Elements {

  def main(args: Array[String]) {

    // Won't properly work
    println(elem("Hello") above elem("world!"))
    println(elem(Array("one", "two")) beside elem(Array("one")))
  }
}
