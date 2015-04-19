package com.my.scala.chapter14

import org.scalatest.Suite
import Element.elem

class ElementSuite extends Suite {

  def testUniformElement() = {
    val ele = elem('x', 2, 3)
    assert(ele.width == 2)
  }

  // Informative failure report
  def testUniformElement2() = {
    val ele = elem('x', 2, 3)
    assert(ele.width === 3)
  }

  // Informative failure report with expect() (deprecated)
  def testUniformElement3() = {
    val ele = elem('x', 2, 3)
    expect(3) {
      ele.width
    }
  }

  // Informative failure report with assertResult()
  def testUniformElement4() = {
    val ele = elem('x', 2, 3)
    assertResult(3) {
      ele.width
    }
  }

  // Interception of specific exceptions
  def testUniformElement5() = {
    intercept[IllegalArgumentException] {
      elem('x', -2, 3)
    }
  }
}
