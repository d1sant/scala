package com.my.scala.chapter7

object FilteringCollections {

  def main(args: Array[String]) {

    val filesHere = (new java.io.File(".")).listFiles()
    for (file <- filesHere if file.getName.endsWith(".sbt"))
      println(file)

    // or alternative version is
    for (file <- filesHere)
      if (file.getName.endsWith(".sbt"))
        println(file)

    // more filtering options
    for (file <- filesHere if file.isFile if file.getName.endsWith(".sbt"))
      println(file)
  }
}
