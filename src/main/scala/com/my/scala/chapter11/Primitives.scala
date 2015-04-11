package com.my.scala.chapter11

object Primitives {

  def main(args: Array[String]) {

    println(isEqual(421, 421))
    println(isEqualAny(421, 421))

    // in Scala you won't get to 'string comparison trap': '==' works as 'equals' in Java
    val x = "abcd".substring(2)
    val y = "abcd".substring(2)
    println("x: " + x + ", y: " + y)
    println(x == y)

    // if you need to compare referenced you need to use 'eq' or 'ne' (negative eq):
    val sx = new String("abc")
    val sy = new String("abc")
    println(sx == sy)
    println(sx eq sy)
    println(sx ne sy)
  }

  def isEqual(x: Int, y: Int) = x == y
  def isEqualAny(x: Any, y: Any) = x == y
}
