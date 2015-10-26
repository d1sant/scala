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
  }

  implicit def doubleToInt(x: Double): Int = x.toInt

  implicit def intToRational(x: Int): Rational = new Rational(x, 1)
}
