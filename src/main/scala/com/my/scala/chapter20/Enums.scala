package com.my.scala.chapter20

object Color extends Enumeration {
  val Red = Value
  val Green = Value
  val Blue = Value
}

object Color2 extends Enumeration {
  val Red, Green, Blue = Value
}

object Colors {
  def main(args: Array[String]) {
    import Color._
    val r = Red
    val g = Green
    val b = Blue
    println("Red Id is " + r.id)
    println("Green Id is " + g.id)
    println("Blue Id is " + b.id)
  }
}

object Direction extends Enumeration {
  val North, East, South, West = Value
}

object Direction2 extends Enumeration {
  val North = Value("North")
  val East = Value("East")
  val South = Value("South")
  val West = Value("West")
}

object Directions2 {
  def main(args: Array[String]) {
    for (d <- Direction2.values) print(d + " ")
    println()
    println(Direction2.East.id)
    println(Direction2(1))
  }
}
