package com.my.scala.chapter2

object HelloWorld {
  def main (args: Array[String]) {
    val msg = "Hello, world!"
    println(msg)
    val msg2: java.lang.String = "Hello again, world!"
    println(msg2)
    val msg3: String = "Hello yet again, world!"
    println(msg3)
  }
}
