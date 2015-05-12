package com.my.scala.chapter16

object Lists {

  def main(args: Array[String]) {

    // Lists are immutable and can't be changed by assignment
    val fruit = List("apples", "oranges", "pears")
    val nums = List(1, 2, 3, 4)
    val diag3 =
      List(
        List(1, 0, 0),
        List(0, 1, 0),
        List(0, 0, 1)
      )
    val empty = List()

    val fruitTyped: List[String] = List("apples", "oranges", "pears")
    val numsTyped: List[Int] = List(1, 2, 3, 4)
    val diag3Typed: List[List[Int]] =
      List(
        List(1, 0, 0),
        List(0, 1, 0),
        List(0, 0, 1)
      )
    val emptyTyped: List[Nothing] = List()

    // List() is also type of List[String]!
    val vs: List[String] = List()

    // constructing lists
    val fruitConst = "apples" :: ("oranges" :: ("pears" :: Nil))
    val numsConst = 1 :: (2 :: (3 :: (4 :: Nil)))
    val diag3Const = (1 :: (0 :: (0 :: Nil))) ::
      (0 :: (1 :: (0 :: Nil))) ::
      (0 :: (0 :: (1 :: Nil))) :: Nil
    val emptyConst = Nil

    // we can drop parentheses
    val numsConst2 = 1 :: 2 :: 3 :: 4 :: Nil

    // Nil.head // will throw noSuchElementException

    val unsorted = List(5, 2, 7, 1, 3, 10, 4)
    println(isort(unsorted))

    // pattern matching using lists
    val List(a, b, c) = fruit
    println(a)
    println(b)
    println(c)

    val d :: e :: rest = fruit
    println(d)
    println(e)
    println(rest)

    val unsorted2 = List(5, 2, 7, 1, 3, 10, 4)
    println(isort(unsorted2))

    // concatenating two lists
    println(List(1, 2) ::: List(3, 4, 5, 6))
    println(List() ::: List(1, 2, 3))
    println(List(1, 2, 3, 4) ::: List(5))

    // xs ::: ys ::: zs will interpret as xs ::: (ys ::: zs)

    println(append(List(1, 2), List(3, 4, 5)))

    // List().length == 0 is quite expensive operation comparing to isEmpty if you need to check on emptiness
    println(List(1, 2, 3).length)

    val abcde = List('a', 'b', 'c', 'd', 'e')
    println(abcde.head)
    println(abcde.tail)
    println(abcde.last)
    println(abcde.init)

    // List().init will throw an exception
    // List().last will throw an exception

    println(abcde.reverse) // will produce new reversed list
    println(abcde) // the initial won't be changed cause lists are immutable

    /**
     * a) reverse is its own inverse:
     * xs.reverse.reverse equals xs
     *
     * b) reverse turns init to tail and last to head, except that the ele- ments are reversed:
     * xs.reverse.init equals xs.tail.reverse
     * xs.reverse.tail equals xs.init.reverse
     * xs.reverse.head equals xs.last
     * xs.reverse.last equals xs.head
     */

    println(abcde take 2)
    println(abcde drop 2)
    println(abcde splitAt 2)

    println(abcde apply 2) // rare in scala comparing to array
    println(abcde(2)) // rare in scala comparing to array

    // xs apply n equals (xs drop n).head

    println(abcde.indices)

    // flattening lists
    println(List(List(1, 2), List(3), List(), List(4, 5)).flatten)
    println(fruit.map(_.toCharArray).flatten)
    // List(1, 2, 3).flatten // will produce an error

    // zipping lists
    println(abcde.indices zip abcde)
    val zipped = abcde zip List(1, 2, 3) // will drop unmatched elements
    println(zipped)
    println(abcde.zipWithIndex) // it's more efficient way to match position and element
    println(zipped.unzip) // changing back tuples to list

    val abcdeStr = abcde.toString
    println(abcdeStr)
    println(abcde mkString("[", ",", "]"))
    println(abcde mkString ",")
    println(abcde mkString)

    val buf = new StringBuilder
    abcde addString(buf, "(", ";", ")")
    println(buf)

    // converting lists
    val arr = abcde.toArray
    println(arr.mkString(" "))
    val lst = arr.toList
    println(lst)

    val arr2 = new Array[Int](10)
    List(1, 2, 3) copyToArray(arr2, 3)
    println(arr2.mkString(" "))

    val it = abcde.iterator
    println(it.next())
    println(it.next())

    // merge sort usage
    println(msort((x: Int, y: Int) => x < y)(List(5, 7, 1, 3)))

    val intSort = msort((x: Int, y: Int) => x < y) _
    println(intSort)
    val reverseIntSort = msort((x: Int, y: Int) => x > y) _
    println(reverseIntSort)

    val mixedInts = List(4, 1, 9, 0, 5, 8, 3, 6, 2, 7)
    println(intSort(mixedInts))
    println(reverseIntSort(mixedInts))

    // high-order functions
    println(List(1, 2, 3) map (_ + 1))

    val words = List("the", "quick", "brown", "fox")
    println(words map (_.length))
    println(words map (_.toList.reverse.mkString))

    // difference between map and flatMap methods
    println(words map (_.toList))
    println(words flatMap (_.toList))

    println(List.range(1, 5) flatMap (
        i => List.range(1, i) map (j => (i, j))
      )
    )

    // the same but with 'for'
    println(for (i <- List.range(1, 5); j <- List.range(1, i)) yield (i, j))

    // foreach
    var sum = 0
    List(1, 2, 3, 4, 5) foreach(sum += _)
    println(sum)

    // filtering lists
    println(List(1, 2, 3, 4, 5) filter (_ % 2 == 0))
    println(words filter (_.length == 3))

    println(List(1, 2, 3, 4, 5) partition (_ % 2 == 0))

    println(List(1, 2, 3, 4, 5) find (_ % 2 == 0))
    println(List(1, 2, 3, 4, 5) find (_ <= 0))

    println(List(1, 2, 3, -4, 5) takeWhile(_ > 0))
    println(words dropWhile(_ startsWith "t"))

    val words2 = List("the", "thin", "quick", "brown", "fox")
    println(words2 dropWhile(_ startsWith "t"))

    println(List(1, 2, 3, -4, 5) span (_ > 0))

    // predicates over lists
    println(hasZeroRow(diag3))

    // folding lists
    println(sumFold(List(1, 2, 3, 4)))
    println(productFold(List(1, 2, 3, 4)))

    println(concat(words))
    println(concat2(words))

    println(flattenLeft(List(List(1, 2, 3), List(4, 5, 6))))
    println(flattenRight(List(List(1, 2, 3), List(4, 5, 6))))

    // sorting lists
    println(List(1, -3, 4, 2, 6) sortWith (_ < _))
    println(words sortWith (_.length > _.length))

    // apply method
    println(List.apply(1, 2, 3))

    // range method
    println(List.range(1, 5))
    println(List.range(1, 9, 2))
    println(List.range(9, 1, -3))

    // fill method
    println(List.fill(5)('a'))
    println(List.fill(3)("hello"))
    println(List.fill(2, 3)('b'))

    // tabulate method
    val square = List.tabulate(5)(n => n * n)
    println(square)
    val multiplication = List.tabulate(5, 5)(_ * _)
    println(multiplication)

    // concat method
    println(List.concat(List('a', 'b'), List('c')))
    println(List.concat(List(), List('b'), List('c')))
    println(List.concat())

    // processing multiple list together
    println((List(10, 20), List(3, 4, 5)).zipped.map(_ * _))
    println((List("abc", "de"), List(3, 2)).zipped.forall(_.length == _))
    println((List("abc", "de"), List(3, 2)).zipped.exists(_.length != _))

    // scala's type inference algorithm
    println(msort((x: Char, y: Char) => x > y)(abcde))
    println(abcde sortWith(_ > _))

    // msort(_ > _)(abcde) // won't work cause of missing type error
    msort[Char](_ > _)(abcde)

    // swapping parameters for type inference
    println(msortSwapped(abcde)(_ > _))
  }

  /**
   * Insertion sort algorithm
   */
  def isort(xs: List[Int]): List[Int] =
    if (xs.isEmpty) Nil
    else insert(xs.head, isort(xs.tail))

  def insert(x: Int, xs: List[Int]): List[Int] =
    if (xs.isEmpty || x <= xs.head) x :: xs
    else xs.head :: insert(x, xs.tail)

  /**
   * Insertion sort algorithm rewritten using class matching
   */
  def isort2(xs: List[Int]): List[Int] = xs match {
    case List() => Nil
    case x :: xs1 => insert2(x, isort2(xs1) )
  }

  def insert2(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x <= y) x :: xs
                    else y :: insert2(x, ys)
  }

  def append[T](xs: List[T], ys: List[T]): List[T] =
    xs match {
      case List() => ys
      case x :: xs1 => x :: append(xs1, ys)
    }

  def rev[T](xs: List[T]): List[T] = xs match {
    case List() => xs
    case x :: xs1 => rev(xs1) ::: List(x)
  }

  def msort[T](less: (T, T) => Boolean)
    (xs: List[T]): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (less(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge(msort(less)(ys), msort(less)(zs))
    }
  }

  def hasZeroRow(m: List[List[Int]]) =
    m exists (row => row forall (_ == 0))

  def sumFold(xs: List[Int]): Int = (0 /: xs) (_ + _)
  def productFold(xs: List[Int]): Int = (1 /: xs) (_ * _)

  def concat(words: List[String]): String = ("" /: words) (_ + " " + _)
  def concat2(words: List[String]): String = (words.head /: words.tail) (_ + " " + _)

  def flattenLeft[T](xss: List[List[T]]) = (List[T]() /: xss) (_ ::: _)
  def flattenRight[T](xss: List[List[T]]) = (xss :\ List[T]()) (_ ::: _) // is more efficient

  def reverseLeft[T](xs: List[T]) = (List[T]() /: xs) {(ys, y) => y :: ys}

  def msortSwapped[T](xs: List[T])(less: (T, T) => Boolean): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (less(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge(msort(less)(ys), msort(less)(zs))
    }
  }
}
