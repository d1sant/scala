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

    val xs1 = List(A, G, T, A)
    println(xs1)
    println(RNA1.fromSeq(xs1))
    val rna1 = RNA1(A, U, G, G, T)
    println(rna1.length)
    println(rna1.last)
    println(rna1.take(3))

    val rna2 = RNA2(A, U, G, G, T)
    println(rna2)
    println(rna2 take 3)
    println(rna2 filter (U !=))

    val rna = RNA(A, U, G, G, T)
    println(rna)
    println(rna map {case A => T case b => b})

    println(rna ++ rna)

    println(rna map Base.toInt)
    println(rna ++ List("missing", "data"))

    val m = PrefixMap("abc" -> 0, "abd" -> 1, "al" -> 2, "all" -> 3, "xy" -> 4)
    println(m)
    println(m withPrefix "a")
    val m2: PrefixMap[Int] = PrefixMap("hello" -> 5, "hi" -> 2)
    println(m2)
    println(PrefixMap.empty[String])
    println(m2 map {case (k, v) => (k + "!", "x" * v)})
  }
}
