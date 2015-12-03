package com.my.scala.chapter29

import com.my.scala.chapter29.org.stairwaybook.recipe.{SimpleBrowser, SimpleDatabase}

object ModularProgramming {

  def main(args: Array[String]) {
    val apple = SimpleDatabase.foodNamed("Apple").get
    println(apple)
    println(SimpleBrowser.recipesUsing(apple))
  }
}
