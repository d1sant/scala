package com.my.scala.chapter4

import ChecksumAccumulator3.calculate

/**
 * Use "scalac ChecksumAccumulator3.scala Summer.scala" or "fsc ChecksumAccumulator3.scala Summer.scala"
 * to compile source code and "scala com.my.scala.chapter4.Summer of love" to run it.
 */
object Summer {
  def main(args: Array[String]) {
    for (arg <- args)
      println(arg + ": " + calculate(arg))
  }
}
