package com.my.scala.chapter19

/**
 * A contravariant output channel
 */
trait OutputChannel[-T] {
  def write(x: T)
}

object OutputChannel {
  def main(args: Array[String]) {
    val output1 = new OutputChannel[String]() {
      override def write(x: String): Unit = Nil
    }
    output1.write("Test")
    val output2 = new OutputChannel[AnyRef]() {
      override def write(x: AnyRef): Unit = Nil
    }
    output2.write(AnyRef)
  }
}
