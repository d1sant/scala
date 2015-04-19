package com.my.scala.chapter13.printmenu

import com.my.scala.chapter13.bobsdelights.Fruits
import com.my.scala.chapter13.bobsdelights.showFruit

object PrintMenu {
  def main(args: Array[String]) {
    for (fruit <- Fruits.menu) {
      showFruit(fruit)
    }
  }
}
