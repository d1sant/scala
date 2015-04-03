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

    // partially applied functions
    someNumbers.foreach(println _) // obsolete version with placeholder
    someNumbers.foreach(println)

    def sum(a: Int, b: Int, c: Int) = a + b + c
    println(sum(1, 2, 3))

    val a = sum _
    println(a(1, 2, 3))

    println(a.apply(1, 2, 3)) // under the hood of partially applied functions

    val b = sum(1, _: Int, 3)
    println(b(2)) // only one parameter should be specified to function
    println(b(5))

    // val c = sum will cause an error: missing arguments for method sum
  }
}
