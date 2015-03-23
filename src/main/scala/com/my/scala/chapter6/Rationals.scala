package com.my.scala.chapter6

object Rationals {

  def main(args: Array[String]) {

    println(new Rational(1, 2))
    // println(new Rational(1, 0)) // will throw illegal argument exception cause denominator can't be zero

    val oneHalf = new Rational(1, 2)
    val twoThirds = new Rational(2, 3)
    println(oneHalf add twoThirds)
  }
}
