package com.my.scala.chapter3

object Tuples {
  def main(args: Array[String]) {
    val pair = (99, "Luftballons")
    println(pair._1)
    println(pair._2 + "\n")

    val triple = (100.1, "Ballons", 8)
    println(triple._1)
    println(triple._2)
    println(triple._3)
  }
}
