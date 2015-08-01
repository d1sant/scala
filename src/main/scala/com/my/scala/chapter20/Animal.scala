package com.my.scala.chapter20

class Food
abstract class Animal {
  def eat(food: Food)
}

class Grass extends Food
class Cow extends Animal {
  // override def eat(food: Grass) {} // This won't compile
  override def eat(food: Food) {}
}

class Fish extends Food