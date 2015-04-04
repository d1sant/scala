package com.my.scala.chapter8

object NamedArgs {

  def main(args: Array[String]) {

    println(speed(100, 10)) // traditional approach
    println(speed(distance = 100, time = 10)) // named arguments approach
    println(speed(time = 10, distance = 100)) // reversed version of named arguments approach
  }

  def speed(distance: Float, time: Float): Float =
    distance / time
}
