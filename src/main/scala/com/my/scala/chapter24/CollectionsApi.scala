package com.my.scala.chapter24

import scala.collection.immutable.HashMap
import scala.collection.{LinearSeq, SortedSet}
import scala.collection.mutable.Buffer

object CollectionsApi {

  def main(args: Array[String]) {

    // Mutable and immutable collections
    Traversable(1, 2, 3)
    Iterable("x", "y", "z")
    Map("x" -> 24, "y" -> 25, "z" -> 26)
    SortedSet("hello", "World")
    val x, y, z = 1
    Buffer(x, y, z)
    IndexedSeq(1.0, 2.0)
    val a, b, c = 'a'
    LinearSeq(a, b, c)
    // Specific implementations:
    val list = List(1, 2, 3)
    val hashmap = HashMap("x" -> 24, "y" -> 25, "z" -> 26)

    // toString:
    println(list)
    println(hashmap)

    // map:
    println(List(1, 2, 3) map (_ + 1))
    println(Set(1, 2, 3) map (_ * 2))
  }
}
