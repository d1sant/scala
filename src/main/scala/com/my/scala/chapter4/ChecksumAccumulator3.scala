package com.my.scala.chapter4

class ChecksumAccumulator3 {
  private var sum = 0
  def add(b: Byte) { sum += b }
  def checksum(): Int = ~(sum & 0xFF) + 1
}
