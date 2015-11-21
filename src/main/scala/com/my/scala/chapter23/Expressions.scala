package com.my.scala.chapter23

object Expressions {

  def main(args: Array[String]) {

    val lara = Person("Lara", false)
    val bob = Person("Bob", true)
    val julie = Person("Julie", false, lara, bob)
    val persons = List(lara, bob, julie)

    println(persons filter (p => !p.isMale) flatMap (p => (p.children map (c => (p.name, c.name)))))
    println(persons withFilter(p => !p.isMale) flatMap (p => (p.children map (c => (p.name, c.name)))))

    // easies way to comprehend:
    println(for (p <- persons; if !p.isMale; c <- p.children) yield (p.name, c.name))

    // for ( seq ) yield expr
    // seq is a sequence of generators, definitions, and filters

    // several generators: later generators vary more rapidly than earlier ones
    println(for (x <- List(1, 2); y <- List("one", "two")) yield (x, y))

    def queens(n: Int): List[List[(Int, Int)]] = {
      def placeQueens(k: Int): List[List[(Int, Int)]] =
        if (k == 0)
          List(List())
        else
          for {
            queens <- placeQueens(k - 1)
            column <- 1 to n
            queen = (k, column)
            if isSafe(queen, queens)
          } yield queen :: queens
      placeQueens(n)
    }

    def isSafe(queen: (Int, Int), queens: List[(Int, Int)]) = queens forall (q => !inCheck(queen, q))

    def inCheck(q1: (Int, Int), q2: (Int, Int)) =
      q1._1 == q2._1 || // the same row
      q1._2 == q2._2 || // the same column
      (q1._1 - q2._1).abs == (q1._2 - q2._2).abs // on diagonal
  }

  case class Person(name: String, isMale: Boolean, children: Person*)
}
