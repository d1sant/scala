package com.my.scala.chapter3

/**
 * The build in functionality allows to create tuples up to 22 values, but you can extend them for even more.
 */
object Tuples {

  def main(args: Array[String]) {

    val pair = (99, "Luftballons")
    println(pair._1)
    println(pair._2 + "\n")

    val triple = (100.1, "Ballons", 8)
    println(triple._1)
    println(triple._2)
    println(triple._3 + "\n")

    val quartile = ('a', "the", 1, 4.1)
    println(quartile._1)
    println(quartile._2)
    println(quartile._3)
    println(quartile._4)
  }
}
