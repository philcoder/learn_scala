package com.philipp.hackerrank

import scala.annotation.tailrec

object Fibonacci {
  //this magicNum permits not to exceed fibonacci number from that value
  private val magicNum = 100000007

  def main(args: Array[String]): Unit = {
    //first class func
    val removeFirstElemFromList = (xs: Iterable[String]) => xs.drop(1)
    val inputs = removeFirstElemFromList(io.Source.stdin.getLines().toList)

    for(elem <- inputs){
      println(calcule(elem.toInt))
    }
  }

  def calcule(number:Int): Int = {
    //inner func
     @tailrec def fibonacci(num: Int, a: Int, b: Int): Int = if (num == 0) a else fibonacci(num - 1, b, (a + b) % magicNum)
    return fibonacci(number, 0, 1)
  }
}
