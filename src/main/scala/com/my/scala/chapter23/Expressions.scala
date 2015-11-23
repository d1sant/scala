package com.my.scala.chapter23

object Expressions {

  def main(args: Array[String]) {

    val lara = Person("Lara", false)
    val bob = Person("Bob", true)
    val julie = Person("Julie", false, lara, bob)
    val persons = List(lara, bob, julie)

    println(persons filter (p => !p.isMale) flatMap (p => (p.children map (c => (p.name, c.name)))))
    println(persons withFilter (p => !p.isMale) flatMap (p => (p.children map (c => (p.name, c.name)))))

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

    // Querying with for expressions

    val books: List[Book] =
      List(
        Book(
          "Structure and Interpretation of Computer Programs",
          "Abelson, Harold", "Sussman, Gerald J."
        ),
        Book(
          "Principles of Computer Design",
          "Aho, Alfred", "Ullman, Jeffrey"
        ),
        Book(
          "Programming of Modular-2",
          "Wirth, Niklaus"
        ),
        Book(
          "Elements of ML Programming",
          "Ullman, Jeffrey"
        ),
        Book(
          "The Java Language Specification",
          "Gosling, James", "Joy, Bill", "Steel, Guy", "Bracha, Gilad"
        )
      )

    println(for (b <- books; a <- b.authors if a startsWith ("Gosling")) yield b.title)
    println(for (b <- books if (b.title indexOf "Program") >= 0) yield b.title)
    println(for (b1 <- books; b2 <- books if b1 != b2; a1 <- b1.authors; a2 <- b2.authors if a1 == a2) yield a1)
    println(removeDublicates(for (b1 <- books; b2 <- books if b1 != b2; a1 <- b1.authors; a2 <- b2.authors if a1 == a2) yield a1))
    println(removeDublicates2(for (b1 <- books; b2 <- books if b1 != b2; a1 <- b1.authors; a2 <- b2.authors if a1 == a2) yield a1))

    def removeDublicates[A](xs: List[A]): List[A] = {
      if (xs.isEmpty) xs
      else
        xs.head :: removeDublicates(
          xs.tail filter (x => x != xs.head)
        )
    }

    def removeDublicates2[A](xs: List[A]): List[A] = {
      if (xs.isEmpty) xs
      else
        xs.head :: removeDublicates2(
          for (x <- xs.tail if x != xs.head) yield x
        )
    }

    // Translation of for expressions

    // One generator:
    // for (x <- expr1) yield expr2
    // expr1.map(x => expr2)

    // A generator and a filter:
    // for (x <- expr1 if expr2) yield expr3
    // for (x <- expr1 withFilter (x => expr2)) yield expr3
    // expr1 withFilter (x => expr2) map (x => expr3)
    // or:
    // for (x <- expr1 if expr2; seq) yield expr3
    // for (x <- expr1 withFilter expr2; seq) yield expr3

    // Two generators:
    // for (x <- expr1; y <- expr2; seq) yield expr3
    // expr1.flatMap(x => for (y <- expr2; seq) yield expr3)

    for (b1 <- books; b2 <- books if b1 != b2;
         a1 <- b1.authors; a2 <- b2.authors if a1 == a2)
      yield a1

    books flatMap(b1 =>
      books withFilter (b2 => b1 != b2) flatMap (b2 =>
        b1.authors flatMap (a1 =>
          b2.authors withFilter (a2 => a1 == a2) map (a2 =>
            a1)
          )
        )
      )

    // Translating patterns in generators
    // for ((x1, ..., xn) <- expr1) yield expr2
    // expr1.map {case (x1, ..., xn) => expr2}

    // for (pat <- expr1) yield expr2
    // expr1 withFilter {
    // case pat => true
    // case _=> false
    // } map {
    // case pat => expr2
    // }

    // Translating definitions:
    // for (x <- expr1; y = expr2; seq) yield expr3
    // for ((x, y) <- for (x <- expr1) yield (x, expr2); seq)
    // yield expr3

    // for (x <- 1 to 1000; y = expensiveComputationNotInvolvingX)
    // yield x * y
    // it's usually better to write:
    // val y = expensiveComputationNotInvolvingX
    // for (x <- 1 to 1000) yield x * y

    // Translating for loops:
    // for (x <- expr1) body
    // expr1 foreach (x => body)

    // for (x <- expr1; if expr2; y <- expr3) body
    // expr1 withFilter (x => expr2) foreach (x =>
    //  expr3 foreach (y => body))
  }

  case class Person(name: String, isMale: Boolean, children: Person*)

  case class Book(title: String, authors: String*)

}
