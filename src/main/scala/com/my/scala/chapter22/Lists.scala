package com.my.scala.chapter22

object Lists {

  def main(args: Array[String]) {

    // Lists are covariant:
    val xs = List(1, 2, 3)
    var ys: List[Any] = xs

    // Abstract class list has two subclasses: "::" and "Nil"
    // Three main methods to operate: isEmpty, head, tail

    // Constructing of lists
    val apples = new Apple :: Nil // list's type is Apple
    val fruits = new Orange :: apples // list's type is Fruit
    println(apples)
    println(fruits)

    // A thought experiment (which wouldn't work)
    // def ::(x: T): List[T] = new scala.::(x, this)

    // prefix.head :: prefix.tail ::: this
    // equals (because :: and ::: are right-associative)

    // prefix.head :: (prefix.tail ::: this)
    // equals (because :: binds to the right)

    // (prefix.tail ::: this).::(prefix.head)
    // equals (because ::: binds to the right)

    // this.:::(prefix.tail).::(prefix.head)
  }

  abstract class Fruit
  class Apple extends Fruit
  class Orange extends Fruit
}
