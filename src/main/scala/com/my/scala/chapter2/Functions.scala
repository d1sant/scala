package com.my.scala.chapter2

object Functions {

  def max(x: Int, y: Int): Int = {
    if (x > y) x
    else y
  }

  def max2(x: Int, y: Int) = {
    if (x > y) x else y
  }

  def max3(x: Int, y: Int) = if (x > y) x else y

  def greet() = println("The function without params and result")

  def main(args: Array[String]) {
    println(max(1, 2))
    println(max2(3, 5))
    println(max3(8, 13))
    greet()
  }

}
