package com.philipp.ch6

import java.io.{File, PrintWriter}

//this example from ch9 demonstrates how closures can help you reduce code duplication.
class FileMatcher {

  private def filesHere = (new File(".")).listFiles

  private def filesMatching(query: String, matcher: (String,String) => Boolean) =
    for (file <- filesHere; if matcher(file.getName, query))
      yield file

  //this example variable and param are 'magic'
  def filesEnding(query: String) = filesMatching(query, _.endsWith(_))

  //works like parameter magic
  private def filesMatching(matcher: String => Boolean) =
    for (file <- filesHere; if matcher(file.getName))
      yield file

  //this example only variable are 'magic'
  def filesContaining(query: String) = filesMatching(_.contains(query))

  //that method was replace by 'filesMatching'
  private def filesContainingOld(query: String) =
    for (file <- filesHere; if file.getName.contains(query))
      yield file

  def filesRegex(query: String) = filesMatching(_.matches(query))

  //that method was replace by 'filesMatching'
  private def filesRegexOld(query: String) =
    for (file <- filesHere; if file.getName.matches(query))
      yield file

  //example curry functions
  def withPrintWriter(file: File)(op: PrintWriter => Unit) = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  /*
  How to use function above

  val file = new File("date.txt")
  withPrintWriter(file) { writer =>
    writer.println(new java.util.Date)
  }

   */
}
