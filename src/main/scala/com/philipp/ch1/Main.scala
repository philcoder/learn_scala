package com.philipp.ch1

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]): Unit = {
    example1()
  }

  //Unit is like 'void' on java
  def example1(): Unit ={
    var capital = Map("US" -> "Washington", "France" -> "Paris")
    capital += ("Japan" -> "Tokyo")
    capital += ("Brazil" -> "BrasIlha")
    println(capital)
    println(capital("US"))

    println("fatorial")
    println(factorial(5))
    println(factorial(20))

    new Solution().execute()
  }

  def factorial(x: BigInt): BigInt = if (x == 0) 1 else x * factorial(x - 1)

  def max(x:Int, y:Int): Int = if(x > y) x else y
}
