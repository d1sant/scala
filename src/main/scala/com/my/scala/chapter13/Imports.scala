package com.my.scala.chapter13

// easy access to Fruit
import bobsdelights.Fruit

// easy access to all members of bobsdelights
import bobsdelights._

/**
 * In Scala imports:
 * - may appear anywhere
 * - may refer to objects (singleton or regular) in addition to packages
 * - let you rename and hide some of the imported members
 */
object Imports {

  def main(args: Array[String]) {

    // easy access to all members of Fruits
    import bobsdelights.Fruits._

    val apple:Fruit = Apple
    val orange:Fruit = Orange
    val pear:Fruit = Pear
    val menu:List[Fruit] = Fruits.menu
    println(menu)
    for (fruit <- menu) showFruit(fruit)
  }

  def showFruit(fruit: Fruit): Unit = {
    // importing of the members of a regular (not singleton) object
    import fruit._
    println(name + "s are " + color)
  }

  def hideSomeMembers() {
    import bobsdelights.Fruits.{Apple, Orange}
    val apple = Apple
    val orange = Orange
    // Pear // is not visible
  }

  def renameMembers() {
    import Fruits.{Apple => McIntosh, Orange}
    val mcIntosh = McIntosh
    val orange = Orange
  }

  def renamePackage() {
    import java.{sql => S}
    val date:S.Date = null
  }

  def showFruits() {
    import Fruits.{_}
    val apple = Apple
  }

  def showFruitsWithRename() {
    import Fruits.{Apple => McIntosh,_}
    val mcIntosh = McIntosh
    val orange = Orange
  }

  def showFruitsExceptOff(): Unit = {
    import Fruits.{Pear => _, _}
    val apple = Apple
    val orange = Orange
    // Pear is not visible
  }
}
