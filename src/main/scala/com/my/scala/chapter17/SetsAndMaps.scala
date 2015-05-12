package com.my.scala.chapter17

object SetsAndMaps {

  def main(args: Array[String]) {

    import scala.collection.mutable
    val mutaSet = mutable.Set(1, 2, 3)
    println(mutaSet)

    println("-- Using sets")
    val text = "See Spot run. Run, Spot. Run!"
    println(text)
    val wordsArray = text.split("[ !,.]+")
    println(wordsArray)

    val words = mutable.Set.empty[String]
    for (word <- wordsArray) words += word.toLowerCase
    println(words)
    println(words.size)

    println("-- Common operations with sets")
    val nums = Set(1, 2, 3) // creates immutable set
    println(nums)

    println(nums + 5) // adds an element
    println(nums - 3) // removes an element

    println(nums ++ List(5, 6)) // adds multiple elements
    println(nums -- List(1, 2)) // removes multiple elements

    println(nums & Set(1, 3, 5, 7)) // intersection of two sets (returns Set(1, 3))

    println(nums.size) // size of set
    println(nums.contains(3)) // checks inclusion

    val words2 = mutable.Set.empty[String]
    words2 += "the" // adds element
    println(words2)
    words2 -= "the" // removes element
    println(words2)

    words2 ++= List("do", "re", "mi") // adds multiple elements
    println(words2)
    words2 --= List("do", "re") // removes multiple elements
    println(words2)

    words2.clear() // removes all elements
    println(words2)

    println("-- Using maps")
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
