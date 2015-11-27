package com.my.scala.chapter24

import scala.StringBuilder
import scala.collection.immutable.HashMap
import scala.collection.{BitSet, LinearSeq, SortedSet}
import scala.collection.mutable.Buffer

object CollectionsApi {

  def main(args: Array[String]) {

    // Mutable and immutable collections
    Traversable(1, 2, 3)
    Iterable("x", "y", "z")
    Map("x" -> 24, "y" -> 25, "z" -> 26)
    SortedSet("hello", "World")
    val x, y, z = 1
    Buffer(x, y, z)
    IndexedSeq(1.0, 2.0)
    val a, b, c = 'a'
    LinearSeq(a, b, c)
    // Specific implementations:
    val list = List(1, 2, 3)
    val hashmap = HashMap("x" -> 24, "y" -> 25, "z" -> 26)

    // toString:
    println(list)
    println(hashmap)

    // map:
    println(List(1, 2, 3) map (_ + 1))
    println(Set(1, 2, 3) map (_ * 2))

    // Trait Iterable
    val xs = List(1, 2, 3, 4, 5)
    val git = xs grouped 3
    println(git)
    println(git.next())
    println(git.next())

    val sit = xs sliding 3
    println(sit)
    println(sit.next())
    println(sit.next())

    val ys = List(5, 4, 3, 2, 1)
    val ys1 = List(5, 4, 3)
    println(xs zip ys)
    println(xs zipAll (ys1, 1, 10))
    println(xs.zipWithIndex)

    // apply:
    println(Seq(1, 2, 3)(1))
    println(Set('a', 'b', 'c')('b'))
    println(Set()('b'))
    println(Map('a' -> 1, 'b' -> 10, 'c' -> 100)('b'))

    // The sequence traits Seq, indexedSeq, LinearSeq
    val seq = Seq(1, 2, 3, 4, 5)
    println(seq(1))
    println(seq isDefinedAt 7)
    println(seq indices)
    // index search
    println(seq indexOf 2)
    println(seq indexOfSlice Seq(3, 4))
    println(seq indexWhere(_ > 3))
    println(seq segmentLength (_ > 3, 1))
    println(0 +: seq)
    // addition
    println(seq :+ 0)
    println(seq padTo (10, 0))
    // updates
    println(seq patch (2, Seq(8, 9, 10), 3))
    println(seq updated(2, 0))
    // sorting
    println(Seq(5,1,3,10,-1).sorted)
    // reversals
    println(seq.reverse)
    // comparisons
    // ...
    // Multiset:
    println(seq intersect Seq(1, 3, 4, 10, 20))
    println(seq diff Seq(1, 3, 4, 10, 20))
    println(seq union Seq(1, 3, 4, 10, 20))
    println((seq union Seq(1, 3, 4, 10, 20)).distinct)

    // Buffers
    val buf = Buffer(1, 2, 3)
    println(buf += 5)
    println(buf += (1, 2, 1))
    println(buf ++= Seq(0, 0, 1, 11, 1))
    println(-1 +=: buf)
    println(Seq(-3, -2) ++=: buf)
    println(buf insert(4, 1))
    println(buf insertAll(5, Seq(1, 0, -1)))
    // removals
    println(buf -= 0)
    // cloning
    println(buf.clone)

    // Sets
    val fruit = Set("apple", "orange", "peach", "banana")
    println(fruit("peach"))
    println(fruit("potato"))
    // additions:
    println(fruit + "pinapple")
    println(fruit + ("kiwi", "strawberry"))
    println(fruit ++ Set("kiwi", "strawberry"))
    // removals:
    println(fruit - "apple")
    println(fruit - ("apple", "orange"))
    println(fruit -- Set("apple", "orange"))
    println(fruit.empty)
    // binary:
    println(fruit & Set("orange", "banana", "kiwi"))
    println(fruit intersect Set("orange", "banana", "kiwi"))
    println(fruit | Set("orange", "banana", "kiwi"))
    println(fruit union Set("orange", "banana", "kiwi"))
    println(fruit &~ Set("orange", "banana", "kiwi"))
    println(fruit diff Set("orange", "banana", "kiwi"))

    var s = Set(1, 2, 3)
    println(s)
    s += 4; s -= 2
    println(s)

    val sm = collection.mutable.Set(1, 2, 3)
    println(sm)
    sm += 4
    println(sm)
    sm -= 2
    println(sm)

    val myOrdering = Ordering.fromLessThan[String](_ > _)
    println(myOrdering)

    import scala.collection.immutable.TreeSet
    println(TreeSet.empty(myOrdering))

    val set = TreeSet.empty[String]
    val numbers = set + ("one", "two", "three", "four")
    println(numbers)
    println(numbers range ("one", "two"))
    println(numbers from "three")

    // Maps
    println(Map("x" -> 24, "y" -> 25, "z" -> 26)) // the same as following due to implicit conversion
    println(Map(("x",24), ("y",25), ("z",26)))

    def f(x: String) = {
      println("taking my time."); Thread.sleep(100)
      x.reverse
    }

    val cache = collection.mutable.Map[String, String]()
    def cachedF(s: String) = cache.getOrElseUpdate(s, f(s))
    println(cachedF("abc"))
    println(cachedF("abc"))
    println(cachedFD("def"))
    println(cachedFD("def"))

    // the same but directly
    def cachedFD(arg: String) = cache get arg match {
      case Some(result) => result
      case None =>
        val result = f(arg)
        cache(arg) = result
        result
    }

    // Synchronized sets and maps
    val capitals = MapMaker.makeMap
    println(capitals)
    capitals ++= List("US" -> "Washington", "France" -> "Paris", "Japan" -> "Tokyo")
    println(capitals)
    println(capitals("Japan"))
    println(capitals("New Zealand"))
    println(capitals += ("New Zealand" -> "Wellington"))
    println(capitals("New Zealand"))

    import scala.collection.mutable
    val synchroSet = new mutable.HashSet[Int] with mutable.SynchronizedSet[Int]

    // Concrete immutable collection classes
    // streams:
    val str = 1 #:: 2 #:: 3 #:: Stream.empty
    println(str)

    def fibFrom(a: Int, b: Int): Stream[Int] =
      a #:: fibFrom(b, a + b)
    val fibs = fibFrom(1, 1).take(7)
    println(fibs.toList)

    // vectors:
    val vec = scala.collection.immutable.Vector.empty
    println(vec)
    val vec2 = vec :+ 1 :+ 2
    println(vec2)
    val vec3 = 100 +: vec2
    println(vec3)
    println(vec3(0))

    val vec4 = Vector(1, 2, 3)
    println(vec4)
    println(vec4 updated (2, 4))
    println(vec4)

    // vectors are the default implementation of immutable indexed sequences
    println(collection.immutable.IndexedSeq(1, 2, 3))

    // stacks:
    val stack = scala.collection.immutable.Stack.empty
    println(stack)
    val hasOne = stack.push(1)
    println(hasOne)
    println(stack)
    println(hasOne.top)
    println(hasOne.pop)

    // queues:
    val empty = scala.collection.immutable.Queue[Int]()
    println(empty)
    val has1 = empty.enqueue(1)
    println(has1)
    val has123 = has1.enqueue(List(2, 3))
    println(has123)
    val (element, has23) = has123.dequeue
    println(element)
    println(has23)

    // ranges:
    println(1 to 3)
    println(5 to 14 by 3)
    println(1 until 3)

    // hash tries
    // are a standard way to implement immutable sets and mans efficiently

    // red-black trees
    val treeSet = collection.immutable.TreeSet.empty[Int]
    println(treeSet)
    println(treeSet + 1 + 3 + 3)

    // bit sets
    val bits = scala.collection.immutable.BitSet.empty
    println(bits)
    val moreBits = bits + 3 + 4 + 4
    println(moreBits)
    println(moreBits(3))
    println(moreBits(0))

    // List maps
    val map = collection.immutable.ListMap(1 -> "one", 2 -> "two")
    println(map)
    println(map(2))

    // Concrete mutable collection classes
    // array buffers:
    val arrayBuf = collection.mutable.ArrayBuffer.empty[Int]
    println(arrayBuf)
    arrayBuf += 1
    println(arrayBuf)
    arrayBuf += 10
    println(arrayBuf)
    println(arrayBuf.toArray)

    // list buffers:
    val listBuf = collection.mutable.ListBuffer.empty[Int]
    println(listBuf)
    listBuf += 1
    println(listBuf)
    listBuf += 10
    println(listBuf)
    println(listBuf.toList)

    // string builders:
    val stringBuilder = new StringBuilder()
    println(stringBuilder)
    stringBuilder  += 'a'
    println(stringBuilder)
    stringBuilder ++= "bcdef"
    println(stringBuilder)
    println(stringBuilder.toString())

    // LinkedList
    // DoubleLinkedList
    // MutableList

    // Queues:
    val mqueue = new mutable.Queue[String]()
    println(mqueue)
    mqueue += "a"
    println(mqueue)
    mqueue ++= List("b", "c")
    println(mqueue)
    println(mqueue.dequeue())
    println(mqueue)

    // array sequences

    // stacks:
    val mstack = new scala.collection.mutable.Stack[Int]
    println(mstack)
    mstack.push(1)
    println(mstack)
    mstack.push(2)
    println(mstack)
    println(mstack.top)
    println(mstack)
    println(mstack.pop)
    println(mstack)

    // array stacks

    // hash tables:
    val htab = collection.mutable.HashMap.empty[Int, String]
    println(htab)
    htab += (1 -> "make a web site")
    println(htab)
    htab += (3 -> "profit!")
    println(htab)
    println(htab(1))
    println(htab contains 2)

    // weak hash maps

    // concurrent maps

    // mutable bit sets
    val mbits = scala.collection.mutable.BitSet.empty
    println(mbits)
    println(mbits += 1)
    println(mbits)
    println(mbits += 3)
    println(mbits)
  }

  sealed abstract class TreeT extends Traversable[Int] {
    case class Branch(left: TreeT, right: TreeT) extends TreeT
    case class Node(elem: Int) extends TreeT
    def foreach[U](f: Int => U) = this match {
      case Node(elem) => f(elem)
      case Branch(l, r) => l foreach f; r foreach f
    }
  }
  sealed abstract class TreeI extends Iterable[Int] {
    case class Branch(left: TreeI, right: TreeI) extends TreeI
    case class Node(elem: Int) extends TreeI
    def iterator: Iterator[Int] = this match {
      case Node(elem) => Iterator.single(elem)
      case Branch(l, r) => l.iterator ++ r.iterator
    }
  }

  import scala.collection.mutable.{Map, SynchronizedMap, HashMap}
  object MapMaker {
    def makeMap: Map[String, String] = {
      new HashMap[String, String] with SynchronizedMap[String, String] {
        override def default(key: String) =
          "Why do you want to know"
      }
    }
  }
}
