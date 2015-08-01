package com.my.scala.chapter20

object Animals {

  def main(args: Array[String]) {

    val bessy: Animal = new Cow
    bessy eat new Fish // it works cause method eat accepts any kind of food, but the intention was to show that cows don't eat fish

    val bessy2: Animal2 = new Cow2
    val grass2 = new Grass2
    // bessy2 eat new Fish2 // will through an error of type missmatch
    // bessy2 eat grass2 TODO fix an error
  }
}
