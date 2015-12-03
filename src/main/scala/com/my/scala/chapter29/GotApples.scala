package com.my.scala.chapter29

import com.my.scala.chapter29.org.stairwaybook.recipe._

object GotApples {

  def main(args: Array[String]) {
    val db: Database3 =
      if (args(0) == "student")
        StudentDatabase3
      else
        SimpleDatabase3
    object browser extends Browser3 {
      val database: db.type = db
    }
    val apple = SimpleDatabase3.foodNamed("Apple").get
    for (recipe <- browser.recipesUsing(apple))
      println(recipe)
  }
}
