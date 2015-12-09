package com.my.scala.chapter32

object Actors {

  def main(args: Array[String]) {

    // println(SillyActor.start())
    // Thread.sleep(10000)

    println(SillyActor.start())
    println(SeriousActor.start())

    import scala.actors.Actor._
    val seriousActor2 = actor {
      for (i <- 1 to 5) {
        println("That is the question")
        Thread.sleep(1000)
      }
    }

    println(SillyActor ! "hi there") // nothing happened

    val echoActor = actor {
      while (true) {
        receive {
          case msg =>
            println("received message: " + msg)
        }
      }
    }

    echoActor ! "hi there"
    echoActor ! "15"

    val intActor = actor {
      receive {
        case x: Int => // I only want Ints
          println("Got an Int: " + x)
      }
    }

    intActor ! "hello" // will be ignored
    intActor ! math.Pi // will be ignored

    intActor ! 12

    // Treating native threads as actors
    import scala.actors.Actor._
    self ! "hello"
    println(self.receive { case x => x})
    println(self.receiveWithin(1000) { case x => x}) // wait a sec!
  }
}


import scala.actors._

object SillyActor extends Actor {
  def act = {
    for (i <- 1 to 5) {
      println("I'm acting!")
      Thread.sleep(1000)
    }
  }
}

object SeriousActor extends Actor {
  def act = {
    for (i <- 1 to 5) {
      println("To be or not to be.")
      Thread.sleep(1000)
    }
  }
}
