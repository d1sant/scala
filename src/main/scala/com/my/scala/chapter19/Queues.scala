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
  }
}
