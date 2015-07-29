package com.my.scala.chapter20

class Contrete extends Abstract {
  type T = String
  def transform(x: String): String = x + x
  val initial: String = "hi"
  var current: String = initial
}
