package com.my.scala.chapter3

import scala.collection.mutable.Map

object MutableMaps {

  def main(args: Array[String]) {
    val treasureMap = Map[Int, String]()
    treasureMap += (1 -> "Go to island")
    treasureMap += (2 -> "Find big X on ground")
    treasureMap += (3 -> "Dig")
    println(treasureMap(2))
  }
}
