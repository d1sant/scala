package com.my.scala.chapter7

import scala.util.control.Breaks._
import java.io.{BufferedReader, InputStreamReader}

object BreakSubstitution {

  def main(args: Array[String]) {

    val in = new BufferedReader(new InputStreamReader(System.in))

    breakable {
      while (true) {
        println("? ")
        if (in.readLine() == "") break
      }
    }
  }
}
