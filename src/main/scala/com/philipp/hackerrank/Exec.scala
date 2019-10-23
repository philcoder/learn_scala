package com.philipp.hackerrank

import com.philipp.hackerrank.StringMingLing

object Exec {

  val stdinString = "abcde\npqrst\n"

  System.setIn(new java.io.ByteArrayInputStream(stdinString.getBytes("UTF-8")))

  def main(args: Array[String]): Unit = {
    StringMingLing.main(null)
  }
}
