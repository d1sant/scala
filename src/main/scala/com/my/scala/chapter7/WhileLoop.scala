package com.my.scala.chapter7

object WhileLoop {

  def main(args: Array[String]) {
    println(gcdLoop(3, 27))
  }

  // it shows imperative approach while Rational#gcd written with functional approach
  def gcdLoop(x: Long, y: Long): Long = {
    var a = x
    var b = y
    while (a != 0) {
      val temp = a
      a = b % a
      b = temp
    }
    b
  }
}
