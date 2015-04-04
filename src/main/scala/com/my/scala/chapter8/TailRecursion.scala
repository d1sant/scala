package com.my.scala.chapter8

object TailRecursion {

  def main(args: Array[String]) {
    // boom(5) // with new stack frame for each recursive call
    bang(5) // with no new stack frame for each recursive call
  }

  def isGoodEnough(guess: Double): Boolean = {
    true // TODO implement me
  }

  def improve(guess: Double): Double = {
    guess // TODO implement me
  }

  // NOTE: as turned out, tail-recursion and no-recursion execution time are almost the same

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

  // It's not tail recursive function cause it performs increment after recursive call
  // It'll build a new stack frame for each recursive call
  def boom(x: Int): Int =
    if (x == 0) throw new Exception("boom!")
    else boom(x - 1) + 1

  // It's tail-recursion approach which will be optimized away recursive call by scala compiler
  def bang(x: Int): Int =
    if (x == 0) throw new Exception("bang!")
    else bang(x - 1)

  // LIMITS of tail recursion
  // a) indirect recursion:
  def isEven(x: Int): Boolean =
    if (x == 0) true else isOdd(x - 1)

  def isOdd(x: Int): Boolean =
    if (x == 0) false else isEven(x - 1)
  
  // b) function value:
  val funValue = nestedFun _
  def nestedFun(x: Int): Unit = {
    if (x != 0) { println(x); funValue(x - 1) }
  }
}
