package com.my.scala.chapter25

import scala.collection.mutable.ArrayBuffer

object CollectionsAchitecture {

  def main(args: Array[String]) {

    val buf = new ArrayBuffer[Int]
    val bldr = buf mapResult(_.toArray)

    // BitSet problem
    import collection.immutable.BitSet
    val bits = BitSet(1, 2, 3)
    println(bits map (_ * 2)) // produces bit set
    println(bits map (_.toFloat)) // produces set

    println(Map("a" -> 1, "b" -> 2) map {case (x, y) => (y, x)})
    println(Map("a" -> 1, "b" -> 2) map {case (x, y) => y})

    val xs: Iterable[Int] = List(1, 2, 3)
    println(xs)
    val ys = xs map (x => x * x)
    println(ys)
  }
}
