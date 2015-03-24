package com.my.scala.chapter7

object IterationThroughCollections {

  def main(args: Array[String]) {

    val filesHere = (new java.io.File(".")).listFiles()
    for (file <- filesHere) // 'file <- filesHere' is called generator
      println(file)

    // Ranges with inclusion of upper bound
    for (i <- 1 to 4)
      println("Iteration " + i)

    // Ranges with exclusion of upper bound
    for (i <- 1 until 4)
      println("Iteration " + i)

    // Not common in Scala!
    for (i <- 0 to filesHere.length - 1)
      println(filesHere(i))
  }
}
