package com.my.scala.chapter5

object BooleanOperators {

  def main(args: Array[String]) {

    println(1 > 2)
    println(1 < 2)
    println(3.5f >= 3.6f)
    println('a' >= 'A')

    val thisIsBoring = !true
    println(thisIsBoring)
    println(!thisIsBoring) // prefix unary operator

    val toBe = true
    val question = toBe || !toBe
    println(question)
    val paradox = toBe && !toBe
    println(paradox)

    // example of short-circuit behaviour like in java
    def salt = { println("salt"); false }
    def pepper = { println("pepper"); true }
    println(pepper && salt) // all method should be invoked
    println(salt && pepper) // pepper method won't be invoked
  }
}
