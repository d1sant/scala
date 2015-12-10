package com.my.scala.chapter32

import scala.actors._

object Actors2 {

  def main(args: Array[String]) {

    import scala.actors.Actor._
    // Better performance through thread reuse
    NameResolver.start()
    NameResolver ! ("www.scala-lang.org", self)
    println(self.receiveWithin(1000) { case x => x})
    NameResolver ! ("wwwwww.scala-lang.org", self)
    println(self.receiveWithin(1000) { case x => x})

    // Making case class to increase redundancy in the message
    NameResolver2.start()
    NameResolver2 ! LookupIp("www.scala-lang.org", self)
    println(self.receiveWithin(1000) { case x => x})
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
  // simplification by adding extra info
  def act3() {
    loop {
      react {
        case (name: String, actor: Actor) =>
          actor ! (name, getIp(name))
      }
    }
  }
}

import java.net.{InetAddress, UnknownHostException}

case class LookupIp(hostname: String, respondTo: Actor)
case class LookupResult(name: String, address: Option[InetAddress])

object NameResolver2 extends Actor {
  def act() {
    loop {
      react {
        case LookupIp(name, actor) =>
          actor ! LookupResult(name, getIp(name))
      }
    }
  }
  def getIp(name: String): Option[InetAddress] = {
    try {
      Some(InetAddress.getByName(name))
    } catch {
      case _:UnknownHostException => None
    }
  }
}
