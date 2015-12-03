package com.my.scala.chapter30

import scala.collection.mutable

object ObjectEquality {

  def main(args: Array[String]) {

    // Pitfall #1: Defining equals with the wrong signature.
    val p1, p2 = new Point(1, 2)
    println(p1)
    println(p2)
    val q = new Point(2, 3)
    println(q)
    println(p1 equals p2)
    println(p1 equals q)

    import scala.collection.mutable._
    val coll = HashSet(p1)
    println(coll contains p2)

    val p2a: Any = p2
    println(p1 equals p2a)

    // Pitfall #2: Changing equals without also changing hashCode
    val p21, p22 = new Point2(1, 2)
    println(mutable.HashSet(p21) contains p22)
    val p31, p32 = new Point3(1, 2)
    println(mutable.HashSet(p31) contains p32)

    // Pitfall #3: Defining equals in terms of mutable fields
    val p4 = new Point4(1, 2)
    println(p4)
    val coll4 = HashSet(p4)
    println(coll4 contains p4)
    p4.x += 1
    println(coll4 contains p4)
    println(coll4.iterator contains p4)

    // Pitfall #4: Failing to define equals as an equivalence relation
    val p5 = new Point4(1, 2)
    val cp5 = new ColoredPoint5(1, 2, Color.Red)
    println(p5 equals cp5)
    println(cp5 equals p5)
    println(HashSet[Point4](p5) contains cp5)
    println(HashSet[Point4](cp5) contains p5)

    val p6 = new Point4(1, 2)
    val cp6 = new ColoredPoint6(1, 2, Color.Red)
    println(p6 equals cp6)
    println(cp6 equals p6)

    val redp = new ColoredPoint6(1, 2, Color.Red)
    val bluep = new ColoredPoint6(1, 2, Color.Blue)
    println(redp == p6)
    println(p6 == bluep)
    println(redp == bluep)

    val p7 = new Point7(1, 2)
    // val p7Anon = new Point7(1, 1) {override val y = 2}
    // println(p7 == p7Anon) // returns false

    // finally
    val p8 = new Point8(1, 2)
    val cp8 = new ColoredPoint8(1, 2, Color.Indigo)
    // val p8Anon = new Point8(1, 1) {override val y = 2}
    val coll8 = List(p8)
    println(coll8 contains p8)
    println(coll8 contains cp8)
    // println(coll8 contains p8Anon) // returns true
  }

  class Point(val x: Int, val y: Int) {
    // An utterly wrong definition of equals
    def equals(other: Point): Boolean =
      this.x == other.x && this.y == other.y
  }

  class Point2(val x: Int, val y: Int) {
    // A better definition, but still not perfect
    override def equals(other: Any): Boolean = other match {
      case that: Point2 => this.x == that.x && this.y == that.y
      case _ => false
    }
  }

  class Point3(val x: Int, val y: Int) {
    override def hashCode = 41 * (41 + x) + y
    override def equals(other: Any): Boolean = other match {
      case that: Point3 => this.x == that.x && this.y == that.y
      case _ => false
    }
  }

  class Point4(var x: Int, var y: Int) { // Problematic
    override def hashCode = 41 * (41 + x) + y
    override def equals(other: Any): Boolean = other match {
      case that: Point4 => this.x == that.x && this.y == that.y
      case _ => false
    }
  }

  object Color extends Enumeration {
    val Red, Orange, Yellow, Green, Blue, Indigo, Violet = Value
  }

  class ColoredPoint5(x: Int, y: Int, val color: Color.Value) extends Point4(x, y) { // Problem: equals not symmetric
    override def equals(other: Any) = other match {
      case that: ColoredPoint5 =>
        this.color == that.color && super.equals(that)
      case _ => false
    }
  }

  class ColoredPoint6(x: Int, y: Int, val color: Color.Value) extends Point4(x, y) { // Problem: equals not transitive
  override def equals(other: Any) = other match {
      case that: ColoredPoint6 =>
        (this.color == that.color) && super.equals(that)
      case that: Point4 =>
        that equals this
      case _ => false
    }
  }

  // A technically valid, but unsatisfying, equals method
  class Point7(var x: Int, var y: Int) {
  override def hashCode = 41 * (41 + x) + y
    override def equals(other: Any): Boolean = other match {
      case that: Point7 =>
        this.x == that.x && this.y == that.y &&
        this.getClass == that.getClass
      case _ => false
    }
  }

  class ColoredPoint7(x: Int, y: Int, val color: Color.Value) extends Point7(x, y) {
  override def equals(other: Any) = other match {
      case that: ColoredPoint7 =>
        (this.color == that.color) && super.equals(that)
      case _ => false
    }
  }

  class Point8(var x: Int, var y: Int) {
    override def hashCode = 41 * (41 + x) + y
    override def equals(other: Any): Boolean = other match {
      case that: Point8 =>
        (that canEqual this) &&
        this.x == that.x && this.y == that.y
      case _ => false
    }
    def canEqual(other: Any) = other.isInstanceOf[Point8]
  }

  class ColoredPoint8(x: Int, y: Int, val color: Color.Value)
    extends Point8(x, y) {
    override def hashCode = 41 * super.hashCode + color.hashCode
    override def equals(other: Any) = other match {
      case that: ColoredPoint8 =>
        (that canEqual this) &&
          super.equals(that) && this.color == that.color
      case _ =>
        false
    }
    override def canEqual(other: Any) =
      other.isInstanceOf[ColoredPoint8]
  }
}
