package com.philipp.hackerrank

import scala.annotation.tailrec

object StringMingLing {
  def main(args: Array[String]) {
    val inputs = io.Source.stdin.getLines().toList
    val string1 = inputs(0)
    val string2 = inputs(1)
    val len = string1.length
    println(execution(string1,string2,len))
  }

  def execution(str1:String, str2:String, len:Int): String = execution(str1,str2,new StringBuilder(), 0, len)

  @tailrec def execution(str1:String, str2:String, acc:StringBuilder, count:Int, len:Int): String ={
    if(count == len){
      return acc.toString
    }
    acc += str1.charAt(count)
    acc += str2.charAt(count)
    execution(str1, str2, acc, count+1, len)
  }
}