package com.philipp.hackerrank

import scala.collection.mutable.ListBuffer

object FilterElements {
  def main(args: Array[String]): Unit = {
    var inputs = io.Source.stdin.getLines().toList

    var index = 1
    while(index < inputs.length){
      val numRepetions = inputs(index).split(" ")(1).toInt
      val elems = inputs(index + 1).split(" ")

      //function return tuples
      val (numRepetionsMap, firstOccursList) = computeRepetitions(elems)
      var notFound = true
      firstOccursList.foreach(elem => {
        if(numRepetionsMap.get(elem).get >= numRepetions){
          print(s"$elem ")
          notFound = false
        }
      })

      if(notFound) println("-1") else println()

      index += 2 //next two inputs
    }
  }

  private def computeRepetitions(elems:Array[String]):(scala.collection.mutable.Map[String, Int],ListBuffer[String]) = {
    val firstOccursList = scala.collection.mutable.ListBuffer[String]()
    val numRepetionsMap = scala.collection.mutable.Map[String, Int]()

    for(elem <- elems){
      if(!numRepetionsMap.contains(elem)){
        numRepetionsMap.put(elem, 1)
        firstOccursList.append(elem)
      }else{
        numRepetionsMap.put(elem, numRepetionsMap.get(elem).get + 1)
      }
    }

    return (numRepetionsMap, firstOccursList)
  }
}
