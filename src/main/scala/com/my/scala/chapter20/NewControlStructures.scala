package com.my.scala.chapter20

import java.io.{File, PrintWriter}
import java.net.ServerSocket
import java.util.Date

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
    withPrintWriter2(file) {
      writer => writer.println(new java.util.Date)
    }

    using(new PrintWriter("data.txt")) { writer =>
      writer.println(new Date)
    }

    val serverSocket = new ServerSocket(9999)
    using(serverSocket.accept()) { socket =>
      socket.getOutputStream.write("hello, world\n".getBytes)
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

  def withPrintWriter2(file: File)(op: PrintWriter => Unit) {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  def usingWrong[T, S](obj: T)(operation: T => S) = {
    val result = operation(obj)
    // obj.close() // type error!
    result
  }

  def using[T <: { def close(): Unit}, S](obj: T)
    (operation: T => S) = {
    val result = operation(obj)
    obj.close()
    result
  }
}
