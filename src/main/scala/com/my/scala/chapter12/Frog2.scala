package com.my.scala.chapter12

class Frog2 extends Animal with Philosophical {
  override def toString = "green"
  override def philosophize(): Unit = {
    println("It ain't easy being " + toString + "!")
  }
}
