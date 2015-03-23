package com.my.scala.chapter6

class Rational(n: Int, d: Int) {
  require(d != 0)
  override def toString = n + "/" + d
}
