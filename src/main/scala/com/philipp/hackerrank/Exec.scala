package com.philipp.hackerrank

object Exec {

  val stdinString = "abbc\n"

  System.setIn(new java.io.ByteArrayInputStream(stdinString.getBytes("UTF-8")))

  def main(args: Array[String]): Unit = {
    StringCompression.main(null)
  }
}
