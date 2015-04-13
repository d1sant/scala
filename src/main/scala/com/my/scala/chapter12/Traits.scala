package com.my.scala.chapter12

object Traits {

  def main(args: Array[String]) {

    val frog = new Frog
    println(frog.philosophize())

    val phil: Philosophical = frog
    println(phil)
    println(phil.philosophize())

    val phrog: Philosophical = new Frog2
    println(phrog.philosophize())

    /**
      * Between traits and classes there are two main differences:
      *
      * 1) Traits can't have any class parameters.
      * Example:
      * class Point(x: Int, y: Int) - is Ok
      * trait NoPoint(x: Int, y: Int) - doesn't compile
      *
      * 2) super() in classes is statically bound, in traits is dynamically bound.
      * Example:
      * super.toString - the output for class is known
      * super.toString - the output is undefined and works as stackable modifications
      */
  }
}
