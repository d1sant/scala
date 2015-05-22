package com.my.scala.chapter19

object Queues {

  def main(args: Array[String]) {

    val q = new Queue(List(1, 2), List(3))
    println(q)

    val q1 = q enqueue 4
    println(q1)
    println(q)
  }
}
