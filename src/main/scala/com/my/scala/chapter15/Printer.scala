package com.my.scala.chapter15

object Printer {

  def print(expr: Expr) = expr match {
    case BinOp(op, left, right) =>
      println(expr + " is a binary operator")
    case _ =>
  }

  // using wildcard pattern
  def print2(expr: Expr) = expr match {
    case BinOp(_, _, _) => println(expr + " is a binary operator")
    case _ => println("It's something else")
  }
}
