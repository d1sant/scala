package com.my.scala.chapter8

object Closures {

  def main(args: Array[String]) {

    // not enough context for further function
    // val notEnough = (x: Int) => x + more // will produce an error: not found: value more

    var more = 1
    val addMore = (x: Int) => x + more
    println(addMore(10)) // closure

    more = 9999
    println(addMore(10)) // closures capture variables but not values

    val someNumbers = List(-11, -10, -5, 0, 5, 10)
    var sum = 0
    someNumbers.foreach(sum += _) // closure results are visible outside
    println(sum)

    def makeIncreaser(more: Int) = (x: Int) => x + more

    val inc1 = makeIncreaser(1)
    println(inc1(10))

    val inc9999 = makeIncreaser(9999)
    println(inc9999(10))
  }
}
