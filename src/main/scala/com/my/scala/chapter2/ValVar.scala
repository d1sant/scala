package com.my.scala.chapter2

object ValVar {
  def main(args: Array[String]) {
    val vl1 = 1
    println("Val: " + vl1)
    // val1 = 2 will not work case val is final variable in terms of java
    var vr1 = 1
    println("Var: " + vr1)
    vr1 = 2
    println("Var: " + vr1)
  }
}
