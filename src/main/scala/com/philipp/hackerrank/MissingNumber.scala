package com.philipp.hackerrank

object MissingNumber {
  def main(args: Array[String]): Unit = {
    val input = io.Source.stdin.getLines().toList
    val setA = input(1).split(" ").map(elem => elem.toInt).sorted
    val setB = input(3).split(" ").map(elem => elem.toInt).sorted

    //this difference list isn't optimal execution because exceed time on test4
//    for(elem <- setA){
//      val index = java.util.Arrays.binarySearch(setB, elem)
//      if(index > -1){
//        //remove at index
//        setB = setB.patch(index, Nil, 1)
//      }
//    }

    //the native 'diff' is more fast execution
    //distinct remove duplicated
    setB.diff(setA).distinct.sorted.foreach(elem => print(s"$elem "))
  }
}
