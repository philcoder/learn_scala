package com.philipp.hackerrank

import com.philipp.hackerrank.StringMingLing

object Exec {

  val stdinString = "2\nabcdpqrs\naz"

  System.setIn(new java.io.ByteArrayInputStream(stdinString.getBytes("UTF-8")))

  def main(args: Array[String]): Unit = {
    StringOPermute.main(null)
  }
}
