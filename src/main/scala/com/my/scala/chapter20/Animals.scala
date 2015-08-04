package com.my.scala.chapter20

object Animals {

  def main(args: Array[String]) {

    val bessy: Animal = new Cow
    bessy eat new Fish // it works cause method eat accepts any kind of food, but the intention was to show that cows don't eat fish

    val bessy2: Animal2 = new Cow2
    val grass2 = new Grass2
    // bessy2 eat new Fish2 // will through an error of type missmatch
    // bessy2 eat grass2 TODO fix an error

    val lassie = new Dog2
    // lassie eat (new bessy2.SuitableFood) // will produce an error of type mismatch

    val bootsie = new Dog2
    lassie eat (new bootsie.SuitableFood)

    class Outer {
      class Inner
    }

    val o1 = new Outer
    val o2 = new Outer

    println(new o1.Inner)

    // new Outer#Inner // will through an error of illegal prefix for a construct
  }
}
