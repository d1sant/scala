package com.my.scala.chapter5

object ArithmeticOperations {

  def main(args: Array[String]) {

    println(1.2 + 2.3) // double
    println(3 - 1) // int
    println('b' - 'a') // int
    println('b' - 1) // int
    println(2L * 3L) // long
    println(11 / 4) // int
    println(11 % 4) // int
    println(11.0f / 4.0f) // float
    println(11.0 % 4.0) // double

    println(math.IEEEremainder(11.0, 4.0))

    val neg = 1 + -3 // int
    println(neg)

    val y = +3 // int
    println(y)

    println(+neg) // do nothing
    println(-neg)
  }
}
