package com.my.scala.chapter5

/**
 * NOTE: in scala every method can be an operator
 */
object Operators {

  def main(args: Array[String]) {

    // infix operators:
    val sum = 1 + 2
    println(sum)
    val sumMore = (1).+(2) // the same as previous
    println(sumMore)

    val longSum = 1 + 2L
    println(longSum) // returns long value cause '+' is overloaded ((1).+(2L))

    val s = "Hello, world!"
    println(s indexOf 'o')
    println(s indexOf ('o', 5)) // multiple arguments should be placed in parentheses.

    // prefix operators (unary operator) and can be '+, -, !, and ~':
    println(-2.0)
    println((2.0).unary_-)
  }
}
