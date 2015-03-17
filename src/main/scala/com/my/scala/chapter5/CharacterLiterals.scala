package com.my.scala.chapter5

object CharacterLiterals {

  def main(args: Array[String]) {

    val a = 'A'
    println(a)
    val c = '\101' // octal representation of char. Must be between 0 to 377
    println(c)

    val d = '\u0041' // hexadecimal representation of char. Presided by \\u
    println(d)
    val f = '\u0044'
    println(f)

    val lineFeed = '\n'
    println(lineFeed)
    val backspace = '\b'
    println(backspace)
    val tab = '\t'
    println(tab)
    val formFeed = '\f'
    println(formFeed)
    val carriageReturn = '\r'
    println(carriageReturn)
    val doubleQuote = '\"'
    println(doubleQuote)
    val singleQuote = '\''
    println(singleQuote)
    val backslash = '\\'
    println(backslash)

    // val B\u0041\u0044 = 1 // won't compile cause it's deprecated api
  }
}
