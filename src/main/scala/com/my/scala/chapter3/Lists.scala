package com.my.scala.chapter3

object Lists {

  def main(args: Array[String]) {
    val oneTwoThree = List(1, 2, 3)
    println(oneTwoThree + "\n")

    val oneTwo = List(1, 2)
    val threeFour = List(3, 4)
    val oneTwoThreeFour = oneTwo ::: threeFour
    println(oneTwo + "  and " + threeFour + " were not mutated")
    println("Thus, " + oneTwoThreeFour + " is a new list" + "\n")

    val twoThree = List(2, 3)
    val oneTwoThree2 = 1 :: twoThree
    println(oneTwoThree2 + "\n")

    val oneTwoThree3 = 1 :: 2 :: 3 :: Nil
    println(oneTwoThree3)
    println(oneTwoThree3(2) + "\n") // Scala list are zero based as well as arrays
    // println(oneTwoThree3(3)) -- causes index out of bound exception

    val thrill = "Will" :: "fill" :: "until" :: Nil
    println(thrill.count(s => s.length == 4))

    println(thrill.drop(2))
    println(thrill.dropRight(2))

    println(thrill.exists(s => s == "until"))
    println(thrill.contains("until"))

    println(thrill.filter(s => s.length == 4))

    println(thrill.forall(s => s.endsWith("l")))
    println(thrill.forall(s => s.endsWith("ll")) + "\n")

    thrill.foreach(s => print(s))
    println()
    thrill.foreach(print) // the same but more concise

    println("\n")
    println(thrill.head)
    println(thrill.init)
    println(thrill.tail)
    println(thrill.last + "\n")

    println(thrill.isEmpty)
    println(thrill.length + "\n")

    println(thrill.map(s => s + "y") + "\n")

    println(thrill.mkString(", ") + "\n")

    println(thrill.filterNot(s => s.length == 4))
    println(thrill.reverse)

    println(thrill.sortWith((s, t) => s.charAt(0).toLower < t.charAt(0).toLower))
  }

}
