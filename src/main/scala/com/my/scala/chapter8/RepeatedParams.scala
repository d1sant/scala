package com.my.scala.chapter8

object RepeatedParams {

  def main(args: Array[String]) {

    echo()
    echo("one")
    echo("hello", "world")

    val arr = Array("What's", "up", "doc?")
    // echo(arr) // won't compile cause of error: type mismatch

    // but ...
    echo(arr: _*)
  }

  def echo(args: String*) =
    for (arg <- args) println(arg)
}
