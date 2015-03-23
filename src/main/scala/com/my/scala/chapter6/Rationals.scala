package com.my.scala.chapter6

object Rationals {

  def main(args: Array[String]) {

    println(new Rational(1, 2))
    // println(new Rational(1, 0)) // will throw illegal argument exception cause denominator can't be zero

    val oneHalf = new Rational(1, 2)
    val twoThirds = new Rational(2, 3)
    println(oneHalf add twoThirds)

    println(oneHalf.numer) // accessing to fields
    println(oneHalf.denom)

    println(new Rational(3)) // auxiliary constructor

    println(new Rational(42, 66)) // normalized fields are 11 and 7

    val x = new Rational(1, 2)
    val y = new Rational(2, 3)
    println(x + y)
    println(x.+(y))
    println(x + x * y) // precedence of '*', as defined in scala, is higher that '+'. 5/6 is the result
    println((x + x) * y) // 2/3 is the result
    println(x + (x * y)) // 5/6 is the result

    println(x - x) // 0/1
    println(x - 1) // -1/2

    println(y * y) // 4/9
    println(y * 2) // 4/3

    println(x / x) // 1/1
    println(x / 2) // 1/4
  }
}
