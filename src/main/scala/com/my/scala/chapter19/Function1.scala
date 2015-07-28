package com.my.scala.chapter19

/**
 * Covariance and contravariance of Function1s
 */
trait Function1[-S, +T] {
  def apply(x: S): T
}
