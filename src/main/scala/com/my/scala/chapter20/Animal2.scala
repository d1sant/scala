package com.my.scala.chapter20

class Food2
abstract class Animal2 {
  type SuitableFood <: Food2
  def eat(food: SuitableFood)
}

class Grass2 extends Food2
class Cow2 extends Animal2 {
  type SuitableFood = Grass2
  override def eat(food: Grass2) = {}
}

class Fish2 extends Food2
