package com.my.scala.chapter8

import scala.io.Source

object LocalLongLines2 {

  def processFile(fileName: String, width: Int): Unit = {

    def processLine(line: String): Unit = {
      if (line.length > width) // here we've got an access to outer function's parameters
        println(fileName + ": " + line)
    }

    val source = Source.fromFile(fileName)
    for (line <- source.getLines())
      processLine(line)
  }
}
