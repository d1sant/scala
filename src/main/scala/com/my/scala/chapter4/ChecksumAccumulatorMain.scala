package com.my.scala.chapter4

object ChecksumAccumulatorMain {

  def main(args: Array[String]) {
    val acc1 = new ChecksumAccumulator1
    val csa2 = new ChecksumAccumulator1
    println("acc1.sum = " + acc1.sum)
    println("csa2.sum = " + csa2.sum)

    acc1.sum = 3
    println("acc1.sum = " + acc1.sum)
    println("csa2.sum = " + csa2.sum)

    // acc1 = new ChecksumAccumulator // won't compile, because acc1 is a val

    val acc2 = new ChecksumAccumulator2
    // acc2.sum = 5 // won't compile, cause sum is private

    println("calculated.sum = " + ChecksumAccumulator3.calculate("Every value is an object."))
  }
}
