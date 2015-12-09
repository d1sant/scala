package com.my.scala.chapter32

import scala.actors._

object Actors2 {

  def main(args: Array[String]) {

    import scala.actors.Actor._
    // Better performance through thread reuse
    NameResolver.start()
    NameResolver ! ("www.scala-lang.org", self)
    println(self.receiveWithin(0) { case x => x})
    NameResolver ! ("wwwwww.scala-lang.org", self)
    println(self.receiveWithin(0) { case x => x})
  }
}

object NameResolver extends actors.Actor {
  import java.net.{InetAddress, UnknownHostException}
  def act() {
    react {
      case (name: String, actor: Actor) =>
        actor ! getIp(name)
        act()
      case "EXIT" =>
        println("Name resolver exiting")
      // quit
      case msg =>
        println("Unhandled message: " + msg)
        act()
    }
  }
  def getIp(name: String): Option[InetAddress] = {
    try {
      Some(InetAddress.getByName(name))
    } catch {
      case _:UnknownHostException => None
    }
  }
  // looping actor forever using loop method
  def act2() {
    loop {
      react {
        case (name: String, actor: Actor) =>
          actor ! getIp(name)
        case msg =>
          println("Unhandled message: " + msg)
      }
    }
  }
}

