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
  }

  case class Person(name: String, isMale: Boolean, children: Person*)
}
