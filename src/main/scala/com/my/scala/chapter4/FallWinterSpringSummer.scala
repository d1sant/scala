package com.my.scala.chapter4

import ChecksumAccumulator3.calculate

/**
 * Note:
 * Application trait is deprecated and we use instead of it App trait.
 */
object FallWinterSpringSummer extends App {
  for (season <- List("fall", "winter", "spring"))
    println(season + ": " + calculate(season))
}
