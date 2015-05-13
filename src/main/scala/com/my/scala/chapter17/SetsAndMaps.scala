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
    val nums = Set(1, 2, 3) // creates an immutable set
    println(nums)

    println(nums + 5) // adds an element
    println(nums - 3) // removes an element

    println(nums ++ List(5, 6)) // adds multiple elements
    println(nums -- List(1, 2)) // removes multiple elements

    println(nums & Set(1, 3, 5, 7)) // intersection of two sets (returns Set(1, 3))

    println(nums.size) // size of the set
    println(nums.contains(3)) // checks for inclusion

    val words2 = mutable.Set.empty[String]
    words2 += "the" // adds an element
    println(words2)
    words2 -= "the" // removes an element
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

    println("-- Common operations with maps")
    val nums2 = Map("i" -> 1, "ii" -> 2) // creates an immutable map
    println(nums2)

    println(nums2 + ("vi" -> 6)) // adds an entry
    println(nums2 - "ii") // removes an entry

    println(nums2 ++ List("iii" -> 3, "v" -> 5)) // adds multiple entries
    println(nums2 -- List("i", "ii")) // removes multiple entries

    println(nums2.size) // size of the map
    println(nums2.contains("ii")) // checks for inclusion
    println(nums2("ii")) // retrieves the value at a specified key

    println(nums2.keys) // returns iterable over "i" and "ii"
    println(nums2.keySet) // returns the keys as a set
    println(nums2.values) // returns the values
    println(nums.isEmpty) // indicates whether the map is empty

    val words3 = mutable.Map.empty[String, Int] // creates an empty, mutable set
    println(words3)

    words3 += ("one" -> 1) // adds a map entry
    println(words3)
    words3 -= "one"
    println(words3) // removes a map entry

    words3 ++= List("one" -> 1, "two" -> 2, "three" -> 3) // adds multiple entries
    println(words3)
    words3 --= List("one", "two") // removes multiple entries
    println(words3)

    // Default set and map
    // Mutable set and map implemented as hashset and hashmap

    // Immutable set and map depend on the size of elements:
    // 0 ->         scala.collection.immutable.EmptySet
    // 1 ->         scala.collection.immutable.Set1
    // 2 ->         scala.collection.immutable.Set2
    // 3 ->         scala.collection.immutable.Set3
    // 4 ->         scala.collection.immutable.Set4
    // 5 or more -> scala.collection.immutable.HashSet

    // 0 ->         scala.collection.immutable.EmptyMap
    // 1 ->         scala.collection.immutable.Map1
    // 2 ->         scala.collection.immutable.Map2
    // 3 ->         scala.collection.immutable.Map3
    // 4 ->         scala.collection.immutable.Map4
    // 5 or more -> scala.collection.immutable.HashMap

    println("-- Sorted sets and maps")
    import scala.collection.immutable.TreeSet
    val ts = TreeSet(9, 3, 1, 8, 0, 2, 7, 4, 6, 5)
    println(ts)

    val cs = TreeSet('f', 'u', 'n')
    println(cs)

    import scala.collection.immutable.TreeMap
    var tm = TreeMap(3 -> 'x', 1 -> 'x', 4 -> 'x')
    println(tm)

    tm += (2 -> 'x')
    println(tm)
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
