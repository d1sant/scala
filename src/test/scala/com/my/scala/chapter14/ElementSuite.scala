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
    assert(ele.width === 2)
  }

  // Informative failure report with expect() (deprecated)
  def testUniformElement3() = {
    val ele = elem('x', 2, 3)
    expect(2) {
      ele.width
    }
  }

  // Informative failure report with assertResult()
  def testUniformElement4() = {
    val ele = elem('x', 2, 3)
    assertResult(2) {
      ele.width
    }
  }

  // Will throw TestFailedException cause elem method doesn't throw exceptions
  // intercept[IllegalArgumentException] {
  //   elem('x', -2, 3)
  // }
}
