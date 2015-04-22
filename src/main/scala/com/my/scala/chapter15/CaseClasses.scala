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
  }
}
