package com.my.scala.chapter9

object ClientCodeSimplifying {

  def main(args: Array[String]) {

    println(containsNeg(List(1, 2, 3, 4)))
    println(containsNeg(List(1, 2, -3, 4)))

    println(containsNeg2(Nil))
    println(containsNeg2(List(0, -1, -2)))
  }

  def containsNeg(nums: List[Int]): Boolean = {
    var exists = false
    for (num <- nums)
      if (num < 0)
        exists = true
    exists
  }

  def containsOdd(nums: List[Int]): Boolean = {
    var exists = false
    for (num <- nums)
      if (num % 2 == 1)
        exists = true
    exists
  }

  // more concise way using built in method
  def containsNeg2(nums: List[Int]) = nums.exists(_ < 0)

  // more concise way using built in method
  def containsOdd2(nums: List[Int]) = nums.exists(_ % 2 == 1)
}
