package com.my.scala.chapter9

/**
 * Reducing code duplication
 */
object FileMatcher {

  private def filesHere = (new java.io.File(".")).listFiles()

  // matching files with specific end
  def filesEnding(query: String) =
    for (file <- filesHere; if file.getName.endsWith(query))
      yield file

  // more common version
  def filesContaining(query: String) =
    for (file <- filesHere; if file.getName.contains(query))
      yield file

  // even more common version
  def filesRegex(query: String) =
    for (file <- filesHere; if file.getName.matches(query))
      yield file
}
