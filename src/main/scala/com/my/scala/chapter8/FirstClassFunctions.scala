package com.my.scala.chapter8

object FirstClassFunctions {

  def main(args: Array[String]) {

    var increase = (x: Int) => x + 1
    println(increase(10))

    increase = (x: Int) => x + 9999
    println(increase(10))

    increase = (x: Int) => {
      println("We")
      println("are")
      println("here!")
      x + 1
    }
    println(increase(10))

    val someNumbers = List(-11, -10, -5, 0, 5, 10)
    someNumbers.foreach((x: Int) => println(x))
  }
}
