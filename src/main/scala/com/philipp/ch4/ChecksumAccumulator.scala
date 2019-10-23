package com.philipp.ch4

import scala.collection.mutable

//example de companion object
object ChecksumAccumulator {
  private val cache = mutable.Map.empty[String, Int]
  private val acc = new ChecksumAccumulator

  def calculate(str: String): Int =
    if (cache.contains(str))
      return cache(str)
    else {
      for (char <- str)
        acc.add(char.toByte)

      val value = acc.checksum()
      cache += (str -> value)

      return value
    }
}

//the private variable and method are acessed from object scala above
class ChecksumAccumulator {
  private var sum = 0

  //method parameters in Scala is that they are vals
  private def add(b: Byte): Unit = {
    sum += b
  }

  def checksum(): Int = ~(sum & 0xFF) + 1
}
