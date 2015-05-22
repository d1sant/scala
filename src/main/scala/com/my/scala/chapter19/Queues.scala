package com.my.scala.chapter19

object Queues {

  def main(args: Array[String]) {

    val q = new Queue(1, 2, 3)
    println(q)

    val q1 = q enqueue 4
    println(q1)
    println(q)
  }
}
