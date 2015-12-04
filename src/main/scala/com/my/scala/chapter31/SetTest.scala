package com.my.scala.chapter31

/*
import org.junit.Test
import org.junit.Assert.assertEquals
class SetTest {
  @Test
  def testMultiAdd: Unit = {
    val set = Set() + 1 + 2 + 3 + 1 + 2 + 3
    assertEquals(3, set.size)
  }
}
*/

/*
import java.lang.annotation.*; // This is Java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Ignore {}
*/

object Test {
  // @Ignore
  def testData = List(0, 1, -1, 5, -5)
  def test1 {
    assert(testData == (testData.head :: testData.tail))
  }
  def test2 {
    assert(testData.contains(testData.head))
  }
}

/*
for {
  method <- Tests.getClass.getMethods
  if method.getName.startsWith("test")
  if method.getAnnotation(classOf[Ignore]) == null
} {
  println("found a test method: " + method)
}
*/
