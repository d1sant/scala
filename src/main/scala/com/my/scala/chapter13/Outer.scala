package com.my.scala.chapter13

/**
 * Private modifiers in Java and Scala are almost the same except of one moment described below:
 */
class Outer {
  class Inner {
    private def f() { println("f") }
    class InnerMost {
      f() // ok
    }
  }
  // (new Inner).f // error: f is not accessible
}
