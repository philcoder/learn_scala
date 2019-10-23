package com.philipp.ch1

import scala.annotation.tailrec

// Hacker-rank Problem: Evaluating e^x
/*
  Expected output:
    2423600.1887
    143.6895
    1.6487
    0.6065
 */
class Solution {
  def execute(): Unit ={
    var evaluate = List(20.0000, 5.0000, 0.5000, -0.5000)
    for (elem <- evaluate) println("%.4f".format(calcule(elem)))
  }

  private def calcule(value: Double): Double ={
    @tailrec def evaluate(value: Double, count:Int, sum:Double): Double ={
      if(count > 0) {
        evaluate(value, count - 1, sum + Math.pow(value, count) / factorial(count))
      }else{
        1 + sum
      }
    }
    //only 9 rounds of calculation
    evaluate(value, 9, 0)
  }

  private def factorial(n: BigInt): Double =
  {
    // Using tail recursion on scala need to use acc on recursion operations
    @tailrec def factorialAcc(acc: BigInt, n: BigInt): BigInt = if (n <= 1) acc else factorialAcc(n * acc, n - 1)
    factorialAcc(1, n).toDouble
  }
}
