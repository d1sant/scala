package com.my.scala.chapter9

import java.io.{File, PrintWriter}

object NewControlStructures {

  def main(args: Array[String]) {

    println(twice(_ + 1, 5))

    withPrintWriter(
      new File("date.txt"),
      writer => writer.println(new java.util.Date)
    )

    // we can substitute parenthesis with curly braces but only for one parameter
    println("Hello, world!")
    println { "Hello, world!" }

    // we can't do it for two or more params
    val g = "Hello, world"
    println(g.substring(7, 9)) // it's ok
    // println(g.substring { 7, 9 }) // it won't work

    val file = new File("date.txt")
    withPrintWriter(file) {
      writer => writer.println(new java.util.Date)
    }
  }

  def twice(op: Double => Double, x: Double) = op(op(x))

  def withPrintWriter(file: File, op: PrintWriter => Unit): Unit = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  def withPrintWriter(file: File)(op: PrintWriter => Unit) {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }
}