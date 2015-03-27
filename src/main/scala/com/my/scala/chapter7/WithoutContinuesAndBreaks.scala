package com.my.scala.chapter7

/**
 * Scala doesn't have continue and break. That's why we must use other approaches to achieve the same functionality.
 */
object WithoutContinuesAndBreaks {

  def main(args: Array[String]) {

    // straight-forward approach
    def searchFrom: Int = {
      var i = 0
      var foundIt = false
      while (i < args.length && !foundIt) {
        if (!args(i).startsWith("-")) {
          if (args(i).endsWith(".scala"))
            foundIt = true
        }
        i = i + 1
      }
      i - 1
    }

    val index1 = searchFrom
    println(index1)
    println(args(index1))

    // recursive approach
    def searchFromR(i: Int): Int =
      if (i >= args.length) -1
      else if (args(i).startsWith("-")) searchFromR(i + 1)
      else if (args(i).endsWith(".scala")) i
      else searchFromR(i + 1)

    val index2 = searchFromR(0)
    println(index2)
    println(args(index2))
  }
}
