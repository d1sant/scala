package com.my.scala.chapter7

object NewCollectionProducing {

  val filesHere = (new java.io.File("./src/main/scala/com/my/scala/chapter7/")).listFiles()

  def main(args: Array[String]) {
     for (length <- forLineLengths) println(length)
  }

  def scalaFiles =
    for {
      file <- filesHere
      if file.getName.endsWith(".scala")
    } yield file

  def fileLines(file: java.io.File) =
    scala.io.Source.fromFile(file).getLines().toList

  def forLineLengths =
    for {
      file <- filesHere
      if file.getName.endsWith(".scala")
      line <- fileLines(file)
      trimmed = line.trim
      if trimmed.matches(".*for.*")
    } yield trimmed.length
}
