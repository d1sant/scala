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

    println(EMail.unapply("John@epfl.ch") equals Some("John", "epfl.ch"))
    println(EMail.unapply("John Doe") equals None)
  }
}

object EMail {
  // The injection method (optional)
  def apply(user: String, domain: String) = user + "@" + domain
  // The extraction method (mandatory)
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2) Some(parts(0), parts(1)) else None
  }
}
