package com.my.scala.chapter13.bobsrockets.navigation5

/**
 * Effects of private qualifiers:
 * no access modifier - public access
 * private[bobsrockets] - access within outer package
 * private[navigation] - same as package visibility in Java
 * private[Navigator] - same as private in Java
 * private[LegOfJourney] - same as private in Scala
 * private[this] - access only from same object
 */
private[bobsrockets] class Navigator {
  protected[navigation5] def useStarChart() {}
  class LegOfJourney {
    private[Navigator] val distance = 100
  }
  private[this] var speed = 200
}
