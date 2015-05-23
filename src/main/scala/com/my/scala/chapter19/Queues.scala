package com.my.scala.chapter19

object Queues {

  def main(args: Array[String]) {

    val q = Queue(1, 2, 3)
    println(q)

    val q1 = q enqueue 4
    println(q1)
    println(q)

    val q2 = Queue2(5, 6, 7)
    println(q2)

    val q3 = q2 enqueue 8
    println(q3)
    println(q2)

    // example of covariant
    doesCompile(Queue2("abc"))
    // doesCompile(Queue2(1, 2, 3)) // won't compile cause Int is subtype of AnyVal

    val c1 = new Cell[String]("abc")
    // val c2: Cell[Any] = c1 // won't compile cause of non-covariant
    // c2.set(1)
    val s: String = c1.get

    // variance of arrays
    val a1 = Array("abc")
    // val a2: Array[Any] = a1 won't compile cause of an error: type mismatch

    val a2: Array[Object] = a1.asInstanceOf[Array[Object]]
  }

  // def doesNotCompile(q: Queue2) = {} // won't compile cause type parameter wasn't defined

  def doesCompileInt(q: Queue2[Int]) = {}
  def doesCompileString(q: Queue2[String]) = {}
  def doesCompile(q: Queue2[AnyRef]) = {}

  class Cell[T](init: T) {
    private[this] var current = init
    def get = current
    def set(x: T) { current = x }
  }
}
