package com.my.scala.chapter5

object BitwiseOperations {

  def main(args: Array[String]) {

    println(1 & 2) // 0
    println(1 | 2) // 3
    println(1 ^ 3) // 2
    println(~1) // -2. Inverts each bit: 0001 --> 111111111111111111111111111111110

    println(-1 >> 31) // -1 NOTE: -1 in binary is 11111111111111111111111111111111
    println(-1 >>> 31) // 1
    println(1 << 2) // 4
  }
}
