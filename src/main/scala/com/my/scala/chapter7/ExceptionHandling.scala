package com.my.scala.chapter7

import java.io.{IOException, FileNotFoundException, FileReader}

object ExceptionHandling {

  def main(args: Array[String]) {
    try {
      val file = new FileReader("input.txt")
      // use and close file
    } catch {
      case ex: FileNotFoundException => // Handle missing file
      case ex: IOException => // Handle other I/O error
    }
    val file2 = new FileReader("input2.txt")
    try {
      // use the file
    } finally {
      file2.close()
    }
  }

  def half(n: Int) =
    if (n % 2 == 0)
      n / 2
    else
      throw new RuntimeException("n must be even")
}
