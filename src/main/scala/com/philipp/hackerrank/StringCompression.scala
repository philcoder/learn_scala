package com.philipp.hackerrank

import scala.annotation.tailrec

object StringCompression {
  def main(args: Array[String]): Unit = {
    val input = io.Source.stdin.getLines().toList(0)
    println(if(input.length == 1) input else execute(input))
  }

  private def execute(input: String):String = execute(input, new StringBuilder, 1, 0, 1)

  @tailrec private def execute(input: String, acc: StringBuilder, strCount:Int, currentIndex:Int, nextIndex:Int):String = {
    if(nextIndex == input.length){
      addToString(input, acc,strCount, currentIndex)
      return acc.toString()
    }

    if(input.charAt(currentIndex) == input.charAt(nextIndex)){
      execute(input, acc, strCount+1, nextIndex, nextIndex+1)
    }else {
      addToString(input, acc,strCount, currentIndex)
      execute(input, acc, 1, nextIndex, nextIndex + 1)
    }
  }

  private def addToString(input: String, acc: StringBuilder, strCount:Int,  currentIndex:Int) ={
    acc += input.charAt(currentIndex)
    if (strCount != 1) {
      acc ++= strCount.toString
    }
  }
}
