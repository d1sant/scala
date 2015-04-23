package com.my.scala.chapter15

object CaseClasses {

  def main(args: Array[String]) {

    // in case classes we don't need to write 'new' operator for creation of instance
    val v = Var("x")
    println(v)
    println(v.name)

    val op = BinOp("+", Number(1), v)
    println(op)
    println(op.operator)
    println(op.left)
    println(op.right)

    // making modified copies
    val op2 = op.copy(operator = "-")
    println(op2)
    println(op2.operator)
    println(op2.left)
    println(op2.right)

    // pattern matching
    import Simplifier.simplifyTop
    val binOp = BinOp("+", Number(1), Number(2))
    println(simplifyTop(UnOp("-", UnOp("-", binOp))))  // Double negation => binOp
    println(simplifyTop(BinOp("+", binOp, Number(0)))) // Adding zero => binOp
    println(simplifyTop(BinOp("*", binOp, Number(1)))) // Multiplying by one => binOp

    import Printer.print
    println(print(binOp))

    // patterns
    println(describe(5))
    println(describe(true))
    println(describe("hello"))
    println(describe(Nil))
    println(describe(List(1,2,3)))
  }

  // wildcard patterns
  def print2(expr: Expr) = expr match {
    case BinOp(_, _, _) => println(expr + " is a binary operator")
    case _ => println("It's something else")
  }

  // constant patterns
  def describe(x: Any) = x match {
    case 5 => "five"
    case true => "truth"
    case "hello" => "hi!"
    case Nil => "the empty list"
    case _ => "something else"
  }
}
