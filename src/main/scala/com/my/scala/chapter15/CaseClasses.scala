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

    println(describe2(0))
    println(describe2(Nil))

    describe3(BinOp("+", Var("x"), Number(0)))
    describe3(BinOp("+", UnOp("-", Var("x")), Number(0)))
    describe3(BinOp("-", UnOp("-", Var("x")), Number(0)))
    describe3(Nil)

    search(List(0, 1, 2))
    search(List(1, 1, 2))

    search2(List(0))
    search2(List(0, 1, 2, 3, 4))

    println(generalSize("abc"))
    println(generalSize(Map(1 -> 'a', 2 -> 'b')))
    println(generalSize(math.Pi))

    println(generalSize2("abcd"))
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

  // variable patterns
  def describe2(x: Any) = x match {
    case 0 => "zero"
    case somethingElse => "not zero " + somethingElse
  }

  // constructor patterns
  def describe3(x: Any) = x match {
    case BinOp("+", e, Number(0)) => println("a deep match")
    case _ =>
  }

  // sequence patterns
  def search(x: Any) = x match {
    case List(0, _, _) => println("found it")
    case _ =>
  }

  def search2(x: Any) = x match {
    case List(0, _*) => println("found it")
    case _ =>
  }

  // typed patterns
  def generalSize(x: Any) = x match {
    case s: String => s.length
    case m: Map[_, _] => m.size
    case _ => -1
  }

  // straight-forward approach without typed patterns
  def generalSize2(x: Any) = {
    if (x.isInstanceOf[String]) {
      val s = x.asInstanceOf[String]
      s.length
    }
  }
}
