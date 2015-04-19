package com.my.scala.chapter14

import org.scalatest.junit.JUnit3Suite
import Element.elem

class JUnitElementSuite extends JUnit3Suite {
  def testUniformElement() {
    val ele = elem('x', 2, 3)
    assert(ele.width === 2)
    assertResult(3) {ele.height}
    intercept[IllegalArgumentException] {
      elem('x', -2, 3)
    }
  }
}
