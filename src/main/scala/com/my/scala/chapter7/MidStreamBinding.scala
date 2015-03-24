package com.my.scala.chapter7

object MidStreamBinding {

  val filesHere = (new java.io.File("./src/main/scala/com/my/scala/chapter7/")).listFiles()

  def main(args: Array[String]) {
    grep(".*gcd.*")
  }

  def fileLines(file: java.io.File) =
    scala.io.Source.fromFile(file).getLines().toList

  def grep(pattern: String) =
    for {
      file <- filesHere
      if file.getName.endsWith(".scala")
      line <- fileLines(file)
      trimmed = line.trim
      if trimmed.matches(pattern)
    } println(file + ": " + trimmed)
}
