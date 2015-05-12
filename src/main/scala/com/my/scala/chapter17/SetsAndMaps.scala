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

    // Using maps
    val map = mutable.Map.empty[String, Int]
    map("hello") = 1
    map("three") = 2
    println(map)
    println(map("hello")) // reading from map

    println(countWords(text))
  }

  def countWords(text: String) = {
    import scala.collection.mutable
    val counts = mutable.Map.empty[String, Int]
    for (rawWord <- text.split("[ ,!.]+")) {
      val word = rawWord.toLowerCase
      val oldCount =
        if (counts.contains(word)) counts(word)
        else 0
      counts += (word -> (oldCount + 1))
    }
    counts
  }
}
