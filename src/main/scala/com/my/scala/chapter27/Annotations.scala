package com.my.scala.chapter27

object Annotations {

  def main(args: Array[String]) {

    // @strategy(@delayed) def f(){} // throws an error: illegal start of simple expression
    @strategy(new delayed) def f(){}
  }

  import annotation._
  class strategy(arg: Annotation) extends Annotation
  class delayed extends Annotation

  // Examples:
  // @deprecated()
  // @deprecated("use newShinyMethod() instead")
  // @volatile
  // @serializable
  // @SerialVersionUID(123)
  // @transient
  // @scala.reflect.BeanProperty
  // @tailrec
  // @unchecked
  // @native
}
