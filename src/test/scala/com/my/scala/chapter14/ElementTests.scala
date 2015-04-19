package com.my.scala.chapter14

import org.testng.annotations.Test
import org.testng.Assert.assertEquals
import Element.elem

class ElementTests {

  @Test def verifyUniformElement(): Unit = {
    val ele = elem('x', 2, 3)
    assertEquals(ele.width, 2)
    assertEquals(ele.height, 3)
  }

  @Test(
    expectedExceptions =
      Array(classOf[IllegalArgumentException])
  )
  def elemShouldThrowIAE() { elem('x', -2, 3)}
}
