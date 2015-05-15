package com.my.scala.chapter17

object Collections {

  def main(args: Array[String]) {

    // initializing collections
    println(List(1, 2, 3))
    println(Set('a', 'b', 'c'))

    import scala.collection.mutable
    println(mutable.Map("hi" -> 2, "there" -> 5))

    println(Array(1.0, 2.0, 3.0).mkString(", "))

    val stuff = mutable.Set(42)
    println(stuff)
    // stuff += "abracadabra" // will cause an error of type mismatch

    val stuff2 = mutable.Set[Any](42) // specifying the type of elements

    val colors = List("blue", "yellow", "red", "green")
    import scala.collection.immutable.TreeSet
    // val treeSet = TreeSet(colors) // will produce an error: implicit value for parameter ord

    val treeSet2 = TreeSet[String]() ++ colors

    println("-- Converting to array or list")
    println(treeSet2.toList)
    println(treeSet2.toArray.mkString(", "))

    println("-- Converting between mutable and immutable sets and maps")
    val mutaSet = mutable.Set.empty ++= treeSet2
    println(mutaSet)
    val immutaSet = Set.empty ++ mutaSet
    println(immutaSet)

    val muta = mutable.Map("i" -> 1, "ii" -> 2)
    println(muta)
    val immu = Map.empty ++ muta
    println(immu)
  }
}
