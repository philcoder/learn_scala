package com.philipp.ch6

class Solution {
  def exec()={
    forFilter()
    //println(wierdExecution)
    switchCaseEquiv()
    closure()
  }

  private def rationalObject() ={
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

  private def forFilter() ={
    val filesHere = (new java.io.File("/")).listFiles

    //produce from for filtered the new collection
    val filteredFiles = for {
      file <- filesHere
      if file.isFile
      if file.getName.contains(".img")
    } yield file

    filteredFiles.foreach{ println }
  }

  //that return will be 1!!!
  //but if use return 1 and return 2, the block will call 2, from finally block return
  //the book recommends to avoid return from finally block
  //scala v2.13.1
  private def wierdExecution(): Int = {
    try {
      println("execute try block")
      1
    } finally  {
      println("execute finally block")
      2
    }
  }

  private def switchCaseEquiv()={
    val food = "chips"

    val suggestion = food match {
      case "salt" => "pepper"
      case "chips" => "salsa"
      case "eggs" => "bacon"
      case _ => "huh?" //default case
    }

    println(suggestion)
  }

  private def closure()={
    //The function value that's created at runtime from this function literal is called a closure.
    def makeIncreaser(more: Int) = (x: Int) => x + more
    val inc1 = makeIncreaser(1)

    println(inc1(10))
    println(inc1(99))
    println(makeIncreaser(5)(100))
  }
}
