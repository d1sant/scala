package com.my.scala.chapter7

object ExceptionHandling {

  def half(n: Int) =
    if (n % 2 == 0)
      n / 2
    else
      throw new RuntimeException("n must be even")
}
