package com.my.scala.chapter6

object Rationals {

  def main(args: Array[String]) {
    println(new Rational(1, 2))
    println(new Rational(1, 0)) // will throw illegal argument exception cause denominator can't be zero
  }
}
