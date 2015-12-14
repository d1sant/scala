package com.my.scala.chapter33

import scala.util.parsing.combinator._
class Arith extends JavaTokenParsers {
  def expr: Parser[Any] = term~rep("+"~term | "-"~term)
  def term: Parser[Any] = factor~rep("*"~factor | "/"~factor)
  def factor: Parser[Any] = floatingPointNumber | "("~expr~")"
}

object ParseExpr extends Arith {

  def main(args: Array[String]) {

    // println("input : " + args(0))
    // println(parseAll(expr, args(0)))

    val input = "2 * (3 + 7)"
    println("input : " + input)
    println(parseAll(expr, input))

    val input2 = "2 * (3 + 7))"
    println("input : " + input2)
    println(parseAll(expr, input2)) // produces an error: failure: string matching regex
  }
}
