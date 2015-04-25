package com.my.scala.chapter15

object Options {

  def main(args: Array[String]) {

    val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
    println(capitals get "France")
    println((capitals get "North Pole") + "\n")

    println(show(capitals get "Japan"))
    println(show(capitals get "France"))
    println(show(capitals get "North Pole"))
  }

  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }
}
