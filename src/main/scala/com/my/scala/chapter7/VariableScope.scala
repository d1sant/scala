package com.my.scala.chapter7

object VariableScope {

  def main(args: Array[String]) {
    sameNameWithinInner()
  }
  
  def printMultiTable(): Unit = {
    var i = 1
    // only i in scope here
    while (i <= 10) {
      var j = 1
      // both i and j in scope here
      while (j <= 10) {
        val prod = (i * j).toString
        // i, j, and k in scope here
        var k = prod.length
        while (k < 4) {
          print(" ")
          k += 1
        }
        print(prod)
        j += 1
      }
      // i and j still in scope; prod and k out of scope
      println()
      i += 1
    }
    // i still in scope; j, prod, and k out of scope
  }

  def sameNameWithinOneScope(): Unit = {
    val a = 1
    // val a = 2 // won't compile
  }

  def sameNameWithinInner(): Unit = {
    val a = 1;
    {
      val a = 2 // Compliles just fine
      println(a)
    }
    println(a)
  }
}
