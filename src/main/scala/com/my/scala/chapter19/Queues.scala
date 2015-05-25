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

    // checking variance annotations
    // val x: Queue[Any] = new StrangeIntQueue // won't compile
    val x: Queue[Int] = new StrangeIntQueue
    // println(x.enqueue("abc)) // won't pass
    println(x.enqueue(9))

    // actually the following is a little bit strange ...
    val y = new QueueLowerBound[Int](List(1), List(2))
    println(y enqueue "abc")
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

  class StrangeIntQueue extends Queue[Int] {
    override def enqueue(x: Int) = {
      println(math.sqrt(x))
      super.enqueue(x)
    }
  }

  abstract class Cat[-T, +U] {
    def meow[W](volume: T, listener: Cat[U, T]): Cat[Cat[U, T], U]
  }

  class QueueLowerBound[+T] (private val leading: List[T], private val trailing: List[T]) {
    def enqueue[U >: T](x: U) =
      new QueueLowerBound[U](leading, x :: trailing)
    override def toString = (leading ::: trailing).toString()
  }
}
