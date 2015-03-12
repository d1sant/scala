package com.my.scala.chapter4

class ChecksumAccumulator2 {

  private var sum = 0

  def add(b: Byte): Unit = {
    // b = 1 // this won't compile, cause b is val
    sum += b
  }

  def checksum(): Int = {
    return ~(sum & 0xFF) + 1
  }
}
