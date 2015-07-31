package com.my.scala.chapter20

object Initialization {

  def main(args: Array[String]) {

    val r = new RationalTrait {
      val numerArg: Int = 1
      val denomArg: Int = 2
    }

    println(r.numerArg)
    println(r.denomArg)

    // an exception will be thrown cause of requirement failure
    val x = 2

    /**
    val r2 = new RationalTrait2 {
      val numerArg: Int = 1 * x
      val denomArg: Int = 2 * x
    }
    */

    // Pre-initialized fields in an anonymous class expression
    val r3 = new {
      val numerArg = 1 * x
      val denomArg = 2 * x
    } with RationalTrait2

    // Pre-initialized fields in an object definition
    object twoThirds extends {
      val numerArg = 2
      val denomArg = 3
    } with RationalTrait2

    // Pre-initialized fields in a class definition
    class RationalClass(n: Int, d: Int) extends {
      val numerArg = n
      val denomArg = d
    } with RationalTrait2 {
      def + (that: RationalClass) = new RationalClass(
        numer * that.denom + that.numer * denom,
        denom * that.denom
      )
    }

    // Lazy vals
    object Demo {
      val x = {println("initializing x 1"); "done 1"}
    }

    val d = Demo
    println(d.x)

    object Demo2 {
      lazy val x = { println("initializing x 2"); "done 2" }
    }

    val d2 = Demo2
    println(d2.x)

    val lr = new LazyRationalTrait {
      val numerArg: Int = 1 * x
      val denomArg: Int = 2 * x
    }
    println(lr.numer)
    println(lr.denom)
  }
}
