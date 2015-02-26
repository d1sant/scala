package com.my.scala.chapter3

object Functional {

  def main(args: Array[String]) {
    printArgsImp(Array("1", "2", "3"))
    printArgsFun(Array("4", "5", "6"))
    printArgsFun2(Array("7", "8", "9"))
    println(formatArgs(Array("10", "11", "12")))

    val res = formatArgs(Array("zero", "one", "two"))
    assert(res == "zero\none\ntwo")
  }

  // Imperative approach with var identifier
  def printArgsImp(args: Array[String]): Unit = {
    var i = 0
    while (i < args.length) {
      println(args(i))
      i += 1
    }
  }

  // More functional approach
  def printArgsFun(args: Array[String]): Unit = {
    for (arg <- args)
      println(arg)
  }

  // More functional approach - concise version
  def printArgsFun2(args: Array[String]): Unit = {
    args.foreach(println)
  }

  // The purest functional approach cause it doesn't return Unit as result and has no side affects (prints to standard output)
  def formatArgs(args: Array[String]) = args.mkString("\n")
}
