package com.my.scala.chapter8

object TailRecursion {

  def main(args: Array[String]) {

  }

  def isGoodEnough(guess: Double): Boolean = {
    true // TODO implement me
  }

  def improve(guess: Double): Double = {
    guess // TODO implement me
  }

  // Tail-recursion approach:
  def approximate(guess: Double): Double =
    if (isGoodEnough(guess)) guess
    else approximate(improve(guess))

  // No-recursion approach for speed up:
  def approximateLoop(initialGuess: Double): Double = {
    var guess = initialGuess
    while (!isGoodEnough(guess))
      guess = improve(guess)
    guess
  }

  // NOTE: as turned out, tail-recursion and no-recursion execution time are almost the same
}
