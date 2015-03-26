package com.my.scala.chapter7

import java.io.{IOException, FileNotFoundException, FileReader}

object ExceptionHandling {

  def main(args: Array[String]) {
    try {
      val f = new FileReader("input.txt")
      // use and close file
    } catch {
      case ex: FileNotFoundException => // Handle missing file
      case ex: IOException => // Handle other I/O error
    }
  }

  def half(n: Int) =
    if (n % 2 == 0)
      n / 2
    else
      throw new RuntimeException("n must be even")
}
