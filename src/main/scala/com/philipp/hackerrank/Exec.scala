package com.philipp.hackerrank

object Exec {

  val stdinString = "2\n9 2\n4 5 2 5 4 3 1 3 4\n9 4\n4 5 2 5 4 3 1 3 4\n"

  System.setIn(new java.io.ByteArrayInputStream(stdinString.getBytes("UTF-8")))

  def main(args: Array[String]): Unit = {
    FilterElements.main(null)
  }
}
