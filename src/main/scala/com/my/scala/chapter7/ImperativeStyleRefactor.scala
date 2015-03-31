package com.my.scala.chapter7

object ImperativeStyleRefactor {

  def main(args: Array[String]) {
    printMultiTable()
    println()
    println(multiTable())
  }

  // Imperative approach:

  def printMultiTable(): Unit = {
    var i = 1
    while (i <= 10) {
      var j = 1
      while (j <= 10) {
        val prod = (i * j).toString
        var k = prod.length
        while (k < 4) {
          print(" ")
          k += 1
        }
        print(prod)
        j += 1
      }
      println()
      i += 1
    }
  }

  // Functional approach:

  // Returns a row as a sequence
  def makeRowSeq(row: Int) =
    for (col <- 1 to 10) yield {
      val prod = (row * col).toString
      val padding = " " * (4 - prod.length)
      padding + prod
    }

  // Returns a row as a string
  def makeRow(row: Int) = makeRowSeq(row).mkString

  // Returns table as a string with one row per line
  def multiTable() = {
    val tableSeq = // a sequence of row settings
      for (row <- 1 to 10)
        yield makeRow(row)
    tableSeq.mkString("\n")
  }
}
