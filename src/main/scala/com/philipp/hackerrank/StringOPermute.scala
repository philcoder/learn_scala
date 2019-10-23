package com.philipp.hackerrank

import scala.annotation.tailrec

object StringOPermute {
  def main(args: Array[String]): Unit = {
    val inputs = removeFirstElemFromList(io.Source.stdin.getLines().toList)

    for (elem <- inputs) println(execution(elem))
  }

  private def execution(str:String): String = execution(str,new StringBuilder, 0, str.length)

  @tailrec private def execution(str:String, acc:StringBuilder, count:Int, len:Int): String ={
    if(count == len){
      return acc.toString
    }
    acc+=str.charAt(count+1)
    acc+=str.charAt(count)
    execution(str,acc,count+2,len)
  }

  private def removeFirstElemFromList[A](xs: Iterable[A]) = xs.drop(1)
}
