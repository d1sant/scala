package com.my.scala.chapter9

/**
 * Refactored version
 */
object FileMatcher2 {

  private def filesHere = (new java.io.File(".")).listFiles()

  private def filesMatching(query: String, matcher: (String, String) => Boolean) = {
    for (file <- filesHere; if matcher(file.getName, query))
      yield file
  }

  def filesEnding(query: String) =
  filesMatching(query, _.endsWith(_))

  def filesContaining(query: String) =
  filesMatching(query, _.contains(_))

  def filesRegex(query: String) =
  filesMatching(query, _.matches(_))

}
