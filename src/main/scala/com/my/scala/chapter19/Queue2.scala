package com.my.scala.chapter19

/**
  * Another implementation of Queue using trait and inner private class
  */
trait Queue2[T] {
  def head: T
  def tail: Queue2[T]
  def enqueue(x: T): Queue2[T]
}
object Queue2 {

  def apply[T](xs: T*): Queue2[T] =
    new Queue2Impl[T](xs.toList, Nil)

  private class Queue2Impl[T] (
    private val leading: List[T],
    private val trailing: List[T]
  ) extends Queue2[T] {

    def mirror =
      if (leading.isEmpty)
        new Queue2Impl(trailing.reverse, Nil)
      else
        this

    def head = mirror.leading.head

    def tail = {
      val q = mirror
      new Queue2Impl(q.leading.tail, q.trailing)
    }

    def enqueue(x: T) =
      new Queue2Impl(leading, x :: trailing)

    override def toString = (leading ::: trailing).toString()
  }
}
