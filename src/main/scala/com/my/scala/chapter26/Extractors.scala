package com.my.scala.chapter26

object Extractors {

  def main(args: Array[String]) {

    // The first approach:

    // def isEMail(s: String): Boolean
    // def domain(s: String): Boolean
    // def user(s: String): Boolean

    // if (isEMail(s)) println(user(s) + " AT" + domain(s))
    // else println("not an email address")

    // EMail(user, domain)

    // The second approach:
    // s match {
    // case EMail(user, domain) => println(user + " AT " + domain)
    // case _ => println("not an email address")
    // }

    // ss match {
    // case EMail(u1, d1) :: EMail(u2, d2) :: _ if (u1 == u2) => ...
  }
}
