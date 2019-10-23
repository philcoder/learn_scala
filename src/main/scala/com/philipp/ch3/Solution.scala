package com.philipp.ch3

import scala.io.Source

class Solution {

  def exec()={
    printFile()
  }

  //array the elements are mutables, on list the elements are immutables
  //array can't change size after instantiate
  private def arrays()={
    val greetStrings = new Array[String](5)
    greetStrings(0) = "Try"
    greetStrings(1) = ", "
    greetStrings(2) = "work "
    greetStrings(3) = "with !"
    greetStrings(4) = "arrays\n"
    for (i <- 0 to 4)
      print(greetStrings(i))

    val numNames = Array("Init ", "array ", "this ", "way!\n")
    numNames(2) = "that "
    numNames.foreach(elem => print(elem))
  }

  private def list()={
    val oneTwo = List(1, 2)
    val threeFour = List(3, 4)
    val concatList = oneTwo ::: threeFour
    println(oneTwo + " and " + threeFour + " were not mutated.")
    println("Thus, " + concatList + " is a new list.")

    val appendElemFrontList = 1 :: threeFour
    println(appendElemFrontList)
    //a concatenacao acontece porque Nil eh uma lista vazia e nao um elemento isolado
    //se terminar como elemento isolado na execucao ocorre error
    //como nao foi especificado ele cria uma List[Any], para elementos mistos igual no append abaixo
    var multipleAppend = 1 :: threeFour :: 6 :: 5 :: 6 :: Nil
    println(multipleAppend)
    println(multipleAppend(2))
    println(multipleAppend.count(elem => elem == 6))
    println(multipleAppend.reverse)

    var intList = List(1,6,7,6)
    println(intList.map(elem => elem * 100))

    val strList = List("one","two","three")
    val lengths = strList.map(_.length)
    println(lengths)

    val patterns = strList.map({
      case "one" => Some(1)
      case "two" => Some(2)
      case _ => None
    })
    println(patterns)
    println(strList.mkString(", "))
    println((strList.filter(elem => elem.length == 3)))
  }

  private def tuples() ={
    //podem ter valores de multi-tipos
    val pair = (99, "Luftballons")
    //a forma de acesso eh desse jeito
    println(pair._1)
    println(pair._2)
  }

  private def collections() ={
    var jetSet = Set("Boeing", "Airbus") //imutable por padrao, por causa do companion object e recomenda usar 'var'
    jetSet += "Lear" //ele cria um novo Set ao fazer append
    println(jetSet.contains("Embraer"))

    //nesse caso como o Set é mutable internamente, pode usar 'val' na variavel
    val soccerSet = scala.collection.mutable.Set("Fortaleza", "Flamengo")
    soccerSet += "Vasco"
    println(soccerSet)

    val stockMap = scala.collection.mutable.Map[String, Double]("PETR4" -> 28.06, "VALE5" -> 45.65)
    stockMap += ("BBAS3" -> 45.06)
    println(stockMap("VALE5"))
    stockMap.foreach{case (key, value) => println(f"key: $key%s -> $value%.2f")}
  }

  private def printFile() ={
    println("Read build.sbt File")
    val lines = Source.fromFile("build.sbt").getLines().toList
    for (line <- lines) {
      println(line)
    }
  }
}
