package com.my.scala.chapter5

object Literals {

  def main(args: Array[String]) {

    val hex = 0x5 // hexadecimal representation of 5
    println(hex)
    val hex2 = 0x00FF // hexadecimal representation of 255
    println(hex2)
    val magic = 0xcafebabe // hexadecimal representation of -889275714
    println(magic)

    // val oct = 035 // won't compile: octal representation is deprecated (29)
    // val nov = 0777 // won't compile: octal representation is deprecated (511)
    // val dec = 0321 // won't compile: octal representation is deprecated (209)

    val dec1 = 31
    println(dec1)
    val dec2 = 255
    println(dec2)
    val dec3 = 20
    println(dec3)

    val prog = 0XCAFEBABEL // long hexadecimal representation of 3405691582
    println(prog)
    val tower = 35L // no matter 'L' or 'l'
    println(tower)
    val of = 31l
    println(of)

    val little: Short = 367
    println(little)
    val littler: Byte = 38
    println(littler)

    val big = 1.2345 // by default it's a double if there is no 'f' in the end of literal
    println(big)
    val bigger = 1.2345e1 // 'e' means exponent portion of 10 by which the other portion is multiplied
    println(bigger)
    val bigger2 = 1.2345e2
    println(bigger2)
    val bigger3 = 1.2345e3
    println(bigger3)
    val bigger4 = 1.2345e4
    println(bigger4)
    val biggerStill = 123E45
    println(biggerStill)

    val littleFloat = 1.2345F // float representation
    println(littleFloat)
    val littleBiggerFloat = 3e5F // float representation of 300000.0
    println(littleBiggerFloat)

    val anotherDouble = 3e5
    println(anotherDouble)
    val yetAnother = 300000.0
    println(yetAnother)
  }
}
