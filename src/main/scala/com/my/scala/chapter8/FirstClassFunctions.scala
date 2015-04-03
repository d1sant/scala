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

    println(someNumbers.filter((x: Int) => x > 0))

    // short form of function literals
    println(someNumbers.filter((x) => x > 0))

    // even shorter form of function literals
    println(someNumbers.filter(x => x > 0))

    // placeholder syntax: the shortest form of function literals
    println(someNumbers.filter(_ > 0))

    // val f = _ + _ won't work cause compiler doesn't have enough information to infer missing parameter types
    val f = (_: Int) + (_: Int)
    println(f(5, 10))
  }
}
