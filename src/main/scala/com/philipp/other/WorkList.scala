package com.philipp.other

object WorkList {
  def main(args: Array[String]): Unit = {
    example1()
  }

  private def example1()={
    val fruit = List("apples", "oranges", "pears")
    val nums = List(1, 2, 3, 4)
    val diag3:List[List[Int]] =
      List(
        List(1, 0, 0),
        List(0, 1, 0),
        List(0, 0, 1)
      )
    val empty = List()

    println(fruit)
    println(nums)
    println(diag3)
    println(empty)

    //list pattern
    val List(a,b,c) = fruit
    println(b)

    val unordered = List(4,1,2,8,3)
    var result = List[Int]()
    for(elem <- unordered){
      result = insertOrdered(elem, result)
    }
    println(unordered)
    println(result)

    println("---")
    println(appendLists(unordered))
    println(appendLists())
    println(appendLists(result, List(100,101,102), unordered))

    println("---")
    println(unordered)
    println(unordered.drop(2))
    println(unordered.take(2))

    //list of list transform to only list
    val listFlat = List(List(1, 2), List(3), List(), List(4, 5)).flatten
    println(listFlat)
    println(listFlat.mkString("[",",","]"))

    val words = List("the", "quick", "brown", "fox")
    println(words.map(_.length))
    println(words.map(_.toList.reverse.mkString))

  }

  //that function pattern works like on erlang
  private def insertOrdered(x:Int, list:List[Int]): List[Int] = list match {
    case List() => List(x)
    case head :: tail => if (x <= head) x :: list else head :: insertOrdered(x, tail)
  }

  private def appendLists(lists: List[Int]*): List[Int] ={
    //example use of pattern on variable
    lists.length match {
      case 0 => List[Int]()
      case 1 => lists(0)
      case _ => {
        //internal function using list pattern
        def append(list1:List[Int], list2:List[Int]): List[Int] = list1 match {
          case List() => list2 //the last element on list1 the recursion append list2
          case head :: tail => head :: appendLists(tail, list2)
        }

        var result = List[Int]()
        for(elem <- lists){
          result = append(result, elem)
        }

        return result
      }
    }
  }
}
