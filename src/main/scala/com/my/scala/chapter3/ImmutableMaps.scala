package com.my.scala.chapter3

object ImmutableMaps {

  def main(args: Array[String]) {
    val romanNumeral = Map(1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V")
    println(romanNumeral(1))
    println(romanNumeral(4))
    romanNumeral.foreach(print)
  }
}
