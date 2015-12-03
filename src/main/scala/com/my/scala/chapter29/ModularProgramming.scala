package com.my.scala.chapter29

import com.my.scala.chapter29.org.stairwaybook.recipe.{SimpleBrowser2, SimpleDatabase2, SimpleBrowser, SimpleDatabase}

object ModularProgramming {

  def main(args: Array[String]) {

    val apple = SimpleDatabase.foodNamed("Apple").get
    println(apple)
    println(SimpleBrowser.recipesUsing(apple))

    val apple2 = SimpleDatabase2.foodNamed("Apple").get
    println(apple2)
    println(SimpleBrowser2.recipesUsing(apple2))
  }
}
