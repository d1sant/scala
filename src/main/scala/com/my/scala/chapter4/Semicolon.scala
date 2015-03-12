package com.my.scala.chapter4

object Semicolon {
  def main(args: Array[String]) {
    val s = "Hello"; // Semicolon is not necessary here
    val s1 = "Hello"; println(s1) // Only for such cases it obligatory to divide statements

    val x = 1
    val y = 2
    val z = 3
    if (x < 2)
      println("too small")
    else
      println("ok")

    // x     // Compilation error
    // + y

    // (x    // Should work but compilation error
    //  + y)

    // x +   // Should work but compilation error
    // y +
    // z
  }
}
