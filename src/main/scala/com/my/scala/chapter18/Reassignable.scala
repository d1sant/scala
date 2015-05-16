package com.my.scala.chapter18

object Reassignable {

  def main(args: Array[String]) {

    val time = new Time
    time.hour = 24
    println(time.hour)

    val therm = new Thermometer
    println(therm)

    therm.celsius = 100
    println(therm)

    therm.fahrenheit = -40
    println(therm)
    therm.fahrenheit = 32
    println(therm)
  }
}
