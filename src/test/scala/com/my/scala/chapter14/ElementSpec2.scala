package com.my.scala.chapter14

import org.scalatest.WordSpec
import org.scalacheck.Prop._
import Element.elem
import org.scalatest.prop.Checkers

class ElementSpec2 extends WordSpec with Checkers {
  "elem result" must {
    "have passed with" in {
      // check((w: Int) => w > 0 ==> (elem('x', w, 3).width == w))
    }
    "have passed height" in {
      // check((h: Int) => h > 0 ==> (elem('x', 2, h).height == h))
    }
  }
}
