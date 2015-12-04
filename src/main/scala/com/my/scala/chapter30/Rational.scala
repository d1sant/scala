package com.my.scala.chapter30

class Rational(n: Int, d: Int) {
  require(d != 0)
  private val g = gcd(n.abs, d.abs)
  val number = (if (d < 0) -n else n) / g
  val denom = d.abs / g
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
  override def equals(other: Any): Boolean =
    other match {
      case that: Rational =>
        (that canEqual this) &&
        number == that.number &&
        denom == that.denom
      case _ => false
    }
  def canEqual(other: Any): Boolean =
    other.isInstanceOf[Rational]
  override def hashCode: Int =
    41 * (
        41 + number
      ) + denom
  override def toString =
    if (denom == 1) number.toString else number + "/" + denom
}
