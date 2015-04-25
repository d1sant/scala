package com.my.scala.chapter15

sealed abstract class Expr2
case class Var2(name: String) extends Expr2
case class Number2(num: Double) extends Expr2
case class UnOp2(operator: String, arg: Expr2) extends Expr
case class BinOp2(operator: String, left: Expr2, right: Expr2) extends Expr2
