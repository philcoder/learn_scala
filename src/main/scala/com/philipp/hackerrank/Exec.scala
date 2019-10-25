package com.philipp.hackerrank

object Exec {

  val stdinString = "5\n0\n1\n5\n10\n10000\n"

  System.setIn(new java.io.ByteArrayInputStream(stdinString.getBytes("UTF-8")))

  def main(args: Array[String]): Unit = {
    Fibonacci.main(null)
  }
}
