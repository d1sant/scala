package com.my.scala.chapter12

/**
 * It doesn't declare a superclass, so like a class it has the default superclass of AnyRef.
 */
trait Philosophical {
  def philosophize() {
    println("I consume memory, therefore I am!")
  }
}
