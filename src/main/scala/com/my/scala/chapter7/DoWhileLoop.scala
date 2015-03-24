package com.my.scala.chapter7

object DoWhileLoop {
  
  def readLineAndPrint() = {
    var line = ""
    do {
      line = readLine()
      println("Read: " + line)
    } while (line != "")
  }
}
