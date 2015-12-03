package com.my.scala.chapter30

trait Tree[+T] {
  def elem: T
  def left: Tree[T]
  def right: Tree[T]
}

object EmptyTree extends Tree[Nothing] {
  def elem =
    throw new NoSuchElementException("EmptyTree.elem")
  def left =
    throw new NoSuchElementException("EmptyTree.left")
  def right =
    throw new NoSuchElementException("EmptyTree.right")
}

class Branch[+T] (
  val elem: T,
  val left: Tree[T],
  val right: Tree[T]
) extends Tree[T] {
  override def equals(other: Any) = other match {
    // case that: Branch[T] => this.elem == that.elem && // previous version: unchecked
    // case that: Branch[t] => this.elem == that.elem && // is analogy to the following
    case that: Branch[_] =>
      (that canEqual this) &&
      this.elem == that.elem &&
      this.left == that.left &&
      this.right == that.right
    case _ => false
  }
  override def hashCode: Int =
   41 * (
     41 * (
      41 + elem.hashCode()
     ) + left.hashCode()
   ) + right.hashCode()
  def canEqual(other: Any) = other match {
    case that: Branch[_] => true
    case _ => false
  }
  // def canEqual(other: Any) = other.isInstanceOf[Branch[_]] // another possible way to do formulate it
}

object Trees {

  def main(args: Array[String]) {

    val b1 = new Branch[List[String]](Nil, EmptyTree, EmptyTree)
    val b2 = new Branch[List[Int]](Nil, EmptyTree, EmptyTree)
    println(b1 == b2)
  }
}
