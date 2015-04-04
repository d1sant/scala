package com.my.scala.chapter8

object DefaultParamValues {

  def main(args: Array[String]) {

    printTime() // the default value will be used
    printTime(Console.err) // redefined value of default parameter

    printTime2(out = Console.err) // redefined value of default parameter using named argument
    printTime2(divisor = 1000) // redefined value of default parameter using named argument
  }

  def printTime(out: java.io.PrintStream = Console.out) =
    out.println("time: " + System.currentTimeMillis())

  def printTime2(out: java.io.PrintStream = Console.out, divisor: Int = 1) =
    out.println("time: " + System.currentTimeMillis() / divisor)
}
