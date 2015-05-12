package com.my.scala.chapter17

object SetsAndMaps {

  def main(args: Array[String]) {

    import scala.collection.mutable
    val mutaSet = mutable.Set(1, 2, 3)
    println(mutaSet)

    // Using sets
    val text = "See Spot run. Run, Spot. Run!"
    println(text)
    val wordsArray = text.split("[ !,.]+")
    println(wordsArray)

    val words = mutable.Set.empty[String]
    for (word <- wordsArray) words += word.toLowerCase
    println(words)
    println(words.size)
  }
}
