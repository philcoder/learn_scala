package com.philipp.ch6

class Solution {
  def exec()={

    val rNumX = new Rational(1,2)
    val rNumY = new Rational(2,3)
    val rNumZ = new Rational(5)
    val rNumK = new Rational(66,42)
    println(rNumX add rNumY)
    println(rNumX max rNumY)
    println(rNumZ)
    println(rNumK)
    println(rNumX * rNumZ) // 5/2
    println((rNumX + rNumY) * rNumZ) // 35/6

    val rNumS = new Rational(2, 3)
    println(rNumS * 5)
  }
}
