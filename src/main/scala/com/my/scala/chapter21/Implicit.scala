package com.my.scala.chapter21

import java.awt.Button
import java.awt.event.{ActionEvent, ActionListener}

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
  }
}
