package com.my.scala.chapter14

import org.scalatest.{Matchers, FlatSpec}
import Element.elem

class ElementSpec extends FlatSpec with Matchers {

  "A UniformElement" should
    "have a width equal to the passed value" in {
    val ele = elem('x', 2, 3)
    ele.width should be (2)
  }

  it should "have a height equaled to the passed value" in {
    val ele = elem('x', 2, 3)
    ele.height should be (3)
  }

  it should "throw an IAE if passed a negative width" in {
    evaluating {
      elem('x', -2, 3)
    } should produce [IllegalArgumentException]
  }

  it should "throw IllegalArgumentException if passed a negative width" in {
    an [IllegalArgumentException] should be thrownBy {
      elem('x', -2, 3)
    }
  }
}
