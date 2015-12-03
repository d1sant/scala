package com.my.scala.chapter29.org.stairwaybook.recipe

import com.my.scala.chapter29.org.stairwaybook.recipe.SimpleDatabase.FoodCategory


abstract class Database {
  def allFoods: List[Food]
  def allRecipes: List[Recipe]
  def foodNamed(name: String) =
    allFoods.find(f => f.name == name)
  case class FoodCategory(name: String, foods: List[Food])
  def allCategories: List[FoodCategory]
}

abstract class Database3 extends FoodCategories {
  def allFoods: List[Food]
  def allRecipes: List[Recipe]
  def foodNamed(name: String) =
    allFoods.find(f => f.name == name)
}

object SimpleDatabase {
  def allFoods = List(Apple, Orange, Cream, Sugar)
  def foodNamed(name: String): Option[Food] =
    allFoods.find(_.name == name)
  def allRecipes: List[Recipe] = List(FruitSalad)
  case class FoodCategory(name: String, foods: List[Food])
  private var categories = List(
    FoodCategory("fruits", List(Apple, Orange)),
    FoodCategory("misc", List(Cream, Sugar))
  )
  def allCategories = categories
}

object SimpleDatabase2 extends Database {
  def allFoods = List(Apple, Orange, Cream, Sugar)
  def allRecipes: List[Recipe] = List(FruitSalad)
  private var categories = List(
    FoodCategory("fruits", List(Apple, Orange)),
    FoodCategory("misc", List(Cream, Sugar))
  )
  def allCategories = categories
}

object SimpleDatabase3 extends Database3 with SimpleFoods with SimpleRecipes

abstract class Browser {
  val database: Database
  def recipesUsing(food: Food) =
    database.allRecipes.filter(recipe =>
      recipe.ingredients.contains(food))

  def displayCategory(category: database.FoodCategory): Unit = {
    println(category)
  }
}

abstract class Browser3 {
  val database: Database3
  def recipesUsing(food: Food) =
    database.allRecipes.filter(recipe =>
      recipe.ingredients.contains(food))

  def displayCategory(category: database.FoodCategory): Unit = {
    println(category)
  }
}

object SimpleBrowser {
  def recipesUsing(food: Food) =
    SimpleDatabase.allRecipes.filter(recipe => recipe.ingredients.contains(food))
  def displayCategory(category: SimpleDatabase.FoodCategory) {
    println(category)
  }
}

object SimpleBrowser2 extends Browser {
  val database = SimpleDatabase2
}

object SimpleBrowser3 extends Browser3 {
  val database = SimpleDatabase3
}

object StudentDatabase extends Database {
  object FrozenFood extends Food("FrozenFood")
  object HeatItUp extends Recipe(
    "heat it up",
    List(FrozenFood),
    "Microwave the 'food' for 10 minutes"
  )
  def allFoods = List(FrozenFood)
  def allRecipes = List(HeatItUp)
  def allCategories = List(
    FoodCategory("edible", List(FrozenFood))
  )
}

object StudentDatabase3 extends Database3 {
  object FrozenFood extends Food("FrozenFood")
  object HeatItUp extends Recipe(
    "heat it up",
    List(FrozenFood),
    "Microwave the 'food' for 10 minutes"
  )
  def allFoods = List(FrozenFood)
  def allRecipes = List(HeatItUp)
  def allCategories = List(
    FoodCategory("edible", List(FrozenFood))
  )
}

object StudentBrowser extends Browser3 {
  val database = StudentDatabase3
}
