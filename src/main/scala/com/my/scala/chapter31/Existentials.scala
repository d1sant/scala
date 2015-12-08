package com.my.scala.chapter31

import scala.collection.mutable

object Existentials {
  def main(args: Array[String]) {
    val contents = (new Wild).contents()
    println(contents)
    println(contents.size())

    /*
    import scala.collection.mutable.Set
    val iter = (new Wild).contents.iterator()
    val set = Set.empty[_] // what type goes here
    while  (iter.hasNext)
      set += iter.next()
    */

    val set = javaSet2ScalaSet(contents)
    println(set)
  }
  import java.util.Collection
  import scala.collection.mutable.Set
  def javaSet2ScalaSet[T](jset: Collection[T]): SetAndType = {
    val sset = Set.empty[T] // now T can be named
    val iter = jset.iterator()
    while (iter.hasNext)
      sset += iter.next()
    return new SetAndType {
      type Elem = T
      val set = sset
    }
  }
}

import scala.collection.mutable.Set
abstract class SetAndType {
  type Elem
  val set: Set[Elem]
}

