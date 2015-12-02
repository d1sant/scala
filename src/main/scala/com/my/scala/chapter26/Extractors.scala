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

    def userTwiceUpper(s: String) = s match {
      case EMail(Twice(x @ UpperCase()), domain) => "match: " + x + " in domain " + domain
      case _ => "no match"
    }

    println(userTwiceUpper("DIDI@hotmail.com"))
    println(userTwiceUpper("DIDO@hotmail.com"))
    println(userTwiceUpper("didi@hotmail.com"))

    def isTomInDotCom(s: String): Boolean = s match {
      case EMail("tom", Domain("com", _*)) => true
      case _ => false
    }

    println(isTomInDotCom("tom@sun.com"))
    println(isTomInDotCom("peterm@sun.com"))
    println(isTomInDotCom("tom@acm.org"))

    val s = "tom@support.epfl.ch"
    val ExpandedEMail(name, topdom, subdoms @ _*) = s
    println(name)
    println(topdom)
    println(subdoms)

    import scala.util.matching.Regex
    val Decimal = new Regex("(-)?(\\d+)(\\.\\d*)?")
    println(Decimal)
    val Decimal1 = new Regex("""(-)?(\d+)(\.\d*)?""")
    println(Decimal1)
    val Decimal2 = """(-)?(\d+)(\.\d*)?""".r
    println(Decimal2)

    val input = "for -1.0 to 99 by 3"
    for (s <- Decimal findAllIn( input))
      println(s)
    println(Decimal findFirstIn input)
    println(Decimal findPrefixOf input)

    val Decimal(sign, integerpart, decimalpart) = "-1.23"
    println(sign)
    println(integerpart)
    println(decimalpart)

    val Decimal(sign1, integerpart1, decimalpart1) = "1.0"
    println(sign1)
    println(integerpart1)
    println(decimalpart1)

    for (Decimal(s, i, d) <- Decimal findAllIn input)
      println("sign: " + s + ", integer: " + i + ", decimal: " + d)
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

object Twice {
  def apply(s: String): String = s + s
  def unapply(s: String): Option[String] = {
    val length = s.length / 2
    val half = s.substring(0, length)
    if (half == s.substring(length)) Some(half) else None
  }
}

object UpperCase {
  def unapply(s: String): Boolean = s.toUpperCase == s
}

object Domain {
  // The injection method (optional)
  def apply(parts: String*): String =
    parts.reverse.mkString(".")
  // The extraction method (mandatory)
  def unapplySeq(whole: String): Option[Seq[String]] =
    Some(whole.split("\\.").reverse)
}

object ExpandedEMail {
  def unapplySeq(email: String)
    : Option[(String, Seq[String])] = {
    val parts = email split "@"
    if (parts.length == 2)
      Some(parts(0), parts(1).split("\\.").reverse)
    else
      None
  }
}
