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

    // Trait Iterable
    val xs = List(1, 2, 3, 4, 5)
    val git = xs grouped 3
    println(git)
    println(git.next())
    println(git.next())

    val sit = xs sliding 3
    println(sit)
    println(sit.next())
    println(sit.next())

    val ys = List(5, 4, 3, 2, 1)
    val ys1 = List(5, 4, 3)
    println(xs zip ys)
    println(xs zipAll (ys1, 1, 10))
    println(xs.zipWithIndex)

    // apply:
    println(Seq(1, 2, 3)(1))
    println(Set('a', 'b', 'c')('b'))
    println(Set()('b'))
    println(Map('a' -> 1, 'b' -> 10, 'c' -> 100)('b'))
  }

  sealed abstract class TreeT extends Traversable[Int] {
    case class Branch(left: TreeT, right: TreeT) extends TreeT
    case class Node(elem: Int) extends TreeT
    def foreach[U](f: Int => U) = this match {
      case Node(elem) => f(elem)
      case Branch(l, r) => l foreach f; r foreach f
    }
  }
  sealed abstract class TreeI extends Iterable[Int] {
    case class Branch(left: TreeI, right: TreeI) extends TreeI
    case class Node(elem: Int) extends TreeI
    def iterator: Iterator[Int] = this match {
      case Node(elem) => Iterator.single(elem)
      case Branch(l, r) => l.iterator ++ r.iterator
    }
  }
}
