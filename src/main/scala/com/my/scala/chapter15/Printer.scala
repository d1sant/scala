package com.my.scala.chapter15

object Printer {
  def print(expr: Expr) = expr match {
    case BinOp(op, left, right) =>
      println(expr + " is a binary operator")
    case _ =>
  }
}
