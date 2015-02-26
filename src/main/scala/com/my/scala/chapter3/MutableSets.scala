package com.my.scala.chapter3

import scala.collection.mutable.Set

object MutableSets {

  def main(args: Array[String]) {
    val movieSet = Set("Hitch", "Poltergeist")
    movieSet += "Shrek" // or movieSet.+=("Shrek")
    println(movieSet)
  }
}
