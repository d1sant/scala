package com.my.scala.chapter19

class Queue3[+T] private (
  private[this] var leading: List[T],
  private[this] var trailing: List[T]
) {
  private def mirror() =
    if (leading.isEmpty) {
      while (!trailing.isEmpty) {
        leading = trailing.head :: leading
        trailing = trailing.tail
      }
    }
  def head: T = {
    mirror()
    leading.head
  }
  def tail: Queue3[T] = {
    mirror()
    new Queue3(leading.tail, trailing)
  }
  def enqueue[U >: T](x: U) =
    new Queue3[U](leading, x :: trailing)
}
