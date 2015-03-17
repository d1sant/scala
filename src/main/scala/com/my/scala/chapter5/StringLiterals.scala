package com.my.scala.chapter5

object StringLiterals {

  def main(args: Array[String]) {

    val hello = "hello"
    println(hello)

    val escapes = "\\\"\'"
    println(escapes)

    val raw = """ Any "string" with any 'char' """
    println(raw)

    println("""Welcome to Ultamix 3000.
               Type "HELP" for help.""")

    println("""|Welcome to Ultamix 3000.
               |Type "HELP" for help.""".stripMargin)
  }
}
