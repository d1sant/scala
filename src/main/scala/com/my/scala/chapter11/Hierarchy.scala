package com.my.scala.chapter11

/**
 * Any is superclass for any classed in scala.
 *
 * Than goes AnyVal and AnyRef
 * Null and Nothing are common subclasses.
 *
 * AnyVal has 9 implementations of built-in value classes: Byte, Short, Char, Int, Long, Float, Double, Boolean, and Unit.
 * This classes are all written as literals and cannot be instantiated with 'new' cause they are abstract and final
 * Unit class corresponds to java void type and it has a single instance value, which is written as '()'
 *
 * AryRef is base class for all reference classes in Scala and corresponds to java.lang.Object. Usage of AnyRef
 * and Object is interchangeable, but preference should be given to AnyRef.
 */
object Hierarchy {

  def main(args: Array[String]) {

    // val one = new Int // cannot be instantiated with 'new' operator

    println(42.toString)
    println(42.hashCode)
    println(42 equals 42)

    // Implicit conversions are used to add more functionality to value types:
    println(42 max 43)
    println(42 min 43)
    println(1 until 5)
    println(1 to 5)
    println(3.abs)
    println((-3).abs)
    // The methods min, max, until, to, and abs are all defined in a class scala.runtime.RichInt
    // and there is an implicit conversion from class Int to RichInt
  }
}
