package com.my.scala.chapter14

import org.scalatest.testng.TestNGSuite
import org.testng.annotations.Test
import Element.elem

class TestNGElementSuite extends TestNGSuite {
  @Test def verifyUniformElement(): Unit = {
    val ele = elem('x', 2, 3)
    assert(ele.width === 2)
    assertResult(3) {ele.height}
    intercept[IllegalArgumentException] {
      elem('x', 2, 3)
    }
  }
}
