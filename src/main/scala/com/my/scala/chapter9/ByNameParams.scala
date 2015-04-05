package com.my.scala.chapter9

object ByNameParams {

  var assertionEnabled = true

  def main(args: Array[String]) {

    myAssert(() => 5 > 3) // it's ok
    // myAssert(5 > 3) // won't work

    // but... we can use by-name params:
    byNameAssert(5 > 3)

    // the main difference between plain params and by-name is order of execution:
    assertionEnabled = false
    val x = 1
    byNameAssert(x / 0 == 0) // won't do any harm
    boolAssert(x / 0 == 0) // will throw an error: java.lang.ArithmeticException: / by zero
  }

  def myAssert(predicate: () => Boolean) =
    if (assertionEnabled && !predicate())
      throw new AssertionError

  def byNameAssert(predicate: => Boolean) =
    if (assertionEnabled && !predicate)
      throw new AssertionError

  // plain approach
  def boolAssert(predicate: Boolean) =
    if (assertionEnabled && !predicate)
      throw new AssertionError
}
