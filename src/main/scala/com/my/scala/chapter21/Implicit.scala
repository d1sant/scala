package com.my.scala.chapter21

import java.awt.Button
import java.awt.event.{ActionEvent, ActionListener}

import com.my.scala.chapter12.{Rational, Rational2}

object Implicit {

  def main(args: Array[String]) {

    val button = new Button()
    button.addActionListener(
      new ActionListener {
        def actionPerformed(e: ActionEvent) {
          println("Pressed!")
        }
      }
    )

    // button.addActionListener( // Type mismatch!
    //   (_: ActionEvent) => println("Pressed!")
    // )

    implicit def function2ActionListener(f: ActionEvent => Unit) =
      new ActionListener {
        def actionPerformed(e: ActionEvent) = f(e)
      }
    
    button.addActionListener(
      function2ActionListener(
        (_: ActionEvent) => println("Pressed!")
      )
    )
    
    // Now this works
    button.addActionListener(
      (_: ActionEvent) => println("Pressed!")
    )

    // Converting to expected type
    val i: Int = 3.5
    println(i)

    // Converting the receiver
    val oneHalf = new Rational(1, 2)
    println(oneHalf + oneHalf)
    println(oneHalf + 1)

    // println(1 + oneHalf) // without implicit it will cause an error cause '1' doesn't have a suitable method

    println(1 + oneHalf)

    val bobsPrompt = new PreferredPrompt("relax> ")
    val bobsDrink = new PreferredDrink("coffee ")
    println(bobsPrompt)
    println(Greeter.greet("Bob")(bobsPrompt, bobsDrink))
    println(Greeter.greet("Joe"))

    println(maxListImplParm(List(1,5,10,3)))
    println(maxListImplParm(List(1.5,5.2,10.7,3.14159)))
    println(maxListImplParm(List("one", "two", "three")))
  }

  implicit def doubleToInt(x: Double): Int = x.toInt

  implicit def intToRational(x: Int): Rational = new Rational(x, 1)

  class PreferredPrompt(val preference: String)

  object Greeter {
    def greet(name: String)(implicit prompt: PreferredPrompt, drink: PreferredDrink) {
      println("Welcome, " + name + ". The system is ready.")
      print("But while you work, ")
      println("why not enjoy a cup of " + drink.preference + "?")
      println(prompt.preference)
    }
  }

  object JoesPrefs {
    implicit val prompt = new PreferredPrompt("Yes, master>")
    implicit val drink = new PreferredPrompt("tea")
  }

  implicit val prompt = new PreferredPrompt("Yes, master>") // without it doesn't work although we defined the same in JoesPrefs object.
  implicit val drink = new PreferredDrink("tea") // without it doesn't work although we defined the same in JoesPrefs object.

  class PreferredDrink(val preference: String)

  // a function with upper bound
  def maxListUpBound[T <: Ordered[T]](elements: List[T]): T =
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListUpBound(rest)
        if (x > maxRest) x
        else maxRest
    }

  def maxListImplParm[T](elements: List[T])
                        (implicit orderer: T => Ordered[T]): T =
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListImplParm(rest)(orderer)
        if (orderer(x) > maxRest) x
        else maxRest
  }

  def maxList[T](elements: List[T])
                (implicit orderer: T => Ordered[T]): T =
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxList(rest) // (orderer) is implicit
        if (x > maxRest) x          // orderer(x) is implicit
        else maxRest
    }

  def maxList[T](elements: List[T])
                (implicit converter: T => Ordered[T]): T =
    elements match {
      // the same body
      case List(x) => x
      // the rest is the same
    }

  def maxList[T](elements: List[T])
                (implicit iceCream: T => Ordered[T]): T =
    elements match {
      // the same body
      case List(x) => x
      // the rest is the same
    }

  def maxList[T <% Ordered[T]](elements: List[T]): T =
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxList(rest) // (orderer) is implicit
        if (x > maxRest) x          // orderer(x) is implicit
        else maxRest
    }
}
