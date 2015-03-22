package com.my.scala.chapter5

object OperatorPrecedence {
  def main(args: Array[String]) {

    println(2 << 2 + 2) // prints 32 cause '+' operator is higher than '<<'
    println(2 + 2 << 2) // 16

    var x = 2
    val y = 2
    x *= y + 1 // operators of assignment (with '=' sign) have lowest precedence
    println(x) // 6
  }
}
