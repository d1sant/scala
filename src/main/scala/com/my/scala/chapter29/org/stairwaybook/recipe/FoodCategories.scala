package com.my.scala.chapter29.org.stairwaybook.recipe

trait FoodCategories {
  case class FoodCategory(name: String, foods: List[Food])
  def allCategories: List[FoodCategory]
}

trait SimpleFoods {
  object Pear extends Food("Pear")
  def allFoods = List(Apple, Pear)
  def allCategories = Nil
}

trait SimpleRecipes {
  this: SimpleFoods =>
  object FruitSatad extends Recipe(
    "fruit salad",
    List(Apple, Pear),
    "Mix it all together"
  )
  def allRecipes = List(FruitSatad)
}
