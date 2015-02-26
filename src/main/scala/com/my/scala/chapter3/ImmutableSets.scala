package com.my.scala.chapter3

import scala.collection.immutable.HashSet

object ImmutableSets {

  def main(args: Array[String]) {
    var jetSet = Set("Boeing", "Airbus")
    jetSet += "Lear" // it's the same as jetSet = jetSet + "Lear"
    println(jetSet.contains("Cessna"))

    val hashSet = HashSet("Tomatoes", "Chilies")
    println(hashSet + "Coriander")
  }
}
