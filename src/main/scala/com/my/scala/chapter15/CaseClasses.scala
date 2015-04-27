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

    println(isIntIntMap(Map(1 -> 1)))
    println(isIntIntMap(Map("abc" -> "abc")))

    println(isStringArray(Array("abc")))
    println(isStringArray(Array(1, 2, 3)))
    
    println(absoluteDuplication(UnOp("abs", UnOp("abs", Var("x")))))

    // pattern guard
    println(simplifyAdd(BinOp("+", Var("x"), Var("x"))))

    // pattern overlap
    println(simplifyAll(UnOp("-", UnOp("-", BinOp("+", binOp, Number(0))))))
    println(simplifyAll(BinOp("+", BinOp("*", binOp, Number(1)), Number(0))))

    // patterns in variable definitions
    val myTuple = (123, "abc")
    val (number, string) = myTuple // defining myltiple variables with one assignment

    val exp = new BinOp("*", Number(5), Number(1))
    val BinOp(opExp, leftExp, rightExp) = exp
    println(opExp)
    println(leftExp)
    println(rightExp)

    // case sequences as partial functions
    val withDefault: Option[Int] => Int = {
      case Some(x) => x
      case None => 0
    }

    println(withDefault(Some(10)))
    println(withDefault(None))

    val second: List[Int] => Int = {
      case x :: y :: _ => y
    }

    println(second(List(5, 6, 7)))
    // println(second(List())) // won't work

    val second2: PartialFunction[List[Int],Int] = {
      case x :: y :: _ => y
    }

    println(second2.isDefinedAt(List(5,6,7)))
    println(second2.isDefinedAt(List()))

    // patterns in 'for' expressions
    val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
    for ((country, city) <- capitals) println("The capital of " + country + " is " + city)

    val result = List(Some("apple"), None, Some("orange"))
    for (Some(fruit) <- result) println(fruit)
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

  // type erasure
  def isIntIntMap(x: Any) = x match {
    case m: Map[Int, Int] => true
    case _ => false
  }

  // although type erasure doesn't apply to arrays
  def isStringArray(x: Any) = x match {
    case a: Array[String] => "yes"
    case _ => "no"
  }
  
  // variable binding
  def absoluteDuplication(expr: Expr) = expr match {
    case UnOp("abs", e @ UnOp("abs", _)) => e
    case _ =>  
  }

  // pattern guard
  def simplifyAdd(e: Expr) = e match {
    case BinOp("+", x, y) if x == y => BinOp("*", x, Number(2))
    case _ => e
  }

  // pattern overlaps
  def simplifyAll(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => simplifyAll(e) // '-' is its own inverse
    case BinOp("+", e, Number(0)) => simplifyAll(e) // '0' is a neutral element for '+'
    case BinOp("*", e, Number(1)) => simplifyAll(e) // '1' is a neutral element for '*'
    case UnOp(op, e) => UnOp(op, simplifyAll(e))
    case BinOp(op, l, r) => BinOp(op, simplifyAll(l), simplifyAll(r))
    case _ => expr
  }

  // next pattern overlap won't compile cause of catch-all cases come after the more specific rule (unreachable code)
  def simplifyBad(expr: Expr): Expr = expr match {
    case UnOp(op, e) => UnOp(op, simplifyBad(e))
    case UnOp("-", UnOp("-", e)) => e
  }

  // sealed classes example: will cause compilation warning that match is not exhaustive
  def describe(e: Expr2): String = e match {
    case Number2(_) => "a number"
    case Var2(_) => "a variable"
  }

  // sealed classes example: an approach for suppress (subdue) warning message
  def describe2(e: Expr2): String = e match {
    case Number2(_) => "a number"
    case Var2(_) => "a variable"
    case _ => throw new RuntimeException // should not happen
  }

  // sealed classes example: another approach for suppress warnings
  def describe3(e: Expr2): String = (e: @unchecked) match {
    case Number2(_) => "a number"
    case Var2(_) => "a variable"
  }
}
