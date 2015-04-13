package com.my.scala.chapter12

object Rationals {

  def main(args: Array[String]) {

    val half = new Rational(1, 2)
    val third = new Rational(1, 3)
    println(half < third)
    println(half > third)

    val half2 = new Rational2(1, 2)
    val third2 = new Rational2(1, 3)
    println(half2 < third2)
    println(half2 > third2)
  }
}
