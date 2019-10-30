package com.philipp.other

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

object MultiThread {

  def main(args: Array[String]): Unit = {
    awaitFuture
  }

  private def awaitFuture ={
    val success = Future { Thread.sleep(5000); 21 + 21 }
    val x = Await.result(success, 15.seconds) //blocks and wait at maximum time
    println(x)
  }

  private def sideEffects = {
    val success = Future { Thread.sleep(5000); 21 + 21 }
    val futStr = Future { "ans" + "wer" }
    //mapped tuple to unique string
    val mapped = success.zipWith(futStr) {
      case (num, str) => s"$num is the $str"
    }

    do{
      println("wait finish tasks")
      Thread.sleep(2000)
    }while(!success.isCompleted || !futStr.isCompleted || !mapped.isCompleted)
    println("finish task")

    println(mapped.value)

    //with success foreach works, but in fail case didn't execute tasks
    success.foreach(elem => println(elem))
  }

  private def asyncExample ={
    val futOk = Future { Thread.sleep(5000); 21 + 21 }
    val futErr = Future { Thread.sleep(6000); 21 / 0 }

    println("Status: "+futOk.value)

    //only blocked for wait results from future tasks
    do{
      println("wait finish tasks")
      Thread.sleep(2000)
    }while(!futOk.isCompleted || !futErr.isCompleted)
    println("finish task")

    println(futOk.value)
    println(futErr.value)

  }

  private def asyncExample2 ={
    val futOk = Future { Thread.sleep(5000); 21 + 21 }

    //when finish task add 1
    futOk.map(elem => elem + 1)
    do{
      println("wait finish tasks")
      Thread.sleep(2000)
    }while(!futOk.isCompleted)
    println("finish task")

    println(futOk.value)
  }

  private def asyncExample3 ={
    val fut1 = Future { Thread.sleep(4000); 21 + 21 }
    val fut2 = Future { Thread.sleep(5500); 30 + 30 }

    //this create a new future and run in parallel
    val newFut = for {
      x <- fut1
      y <- fut2
    } yield x + y

    do{
      println("wait finish tasks")
      Thread.sleep(2000)
    }while(!newFut.isCompleted)

    println("finish task")
    println(fut1.value)
    println(fut2.value)
    println(newFut.value)
  }

  private def serialFutureExample = {
    //this future will run serial and need least 7s for finish
    val serialFuture = for{
      x <- Future { Thread.sleep(2000); 10 * 10 }
      y <- Future { Thread.sleep(3000); 15 * 15 }
    } yield x + y

    do{
      println("wait finish tasks")
      Thread.sleep(2000)
    }while(!serialFuture.isCompleted)

    println("finish task")
    println(serialFuture.value)
  }

  private def futureExceptions = {
    val crazy = Future{ 666 / 0 }
    Thread.sleep(500)

    val expectedFail = crazy.value
    println(expectedFail)

    val success = Future{ 666 / 2 }
    Thread.sleep(500)

    println(success)
    println(success.failed) //NoSuchElementException because the execution was ok

    //reprocess value case some exception is throw by future task
    val recovered = crazy recover {
      case ex: ArithmeticException => -1
    }
    Thread.sleep(500)
    println(recovered.value)

    val recoveryReExecuteFuture = crazy recoverWith {
      case _:ArithmeticException => Future{ 20 * 20}
    }
    Thread.sleep(500)
    println(recoveryReExecuteFuture.value)

    //this case all futures executes in pararell
    val traversed = Future.traverse(List(1,2,3)){
      i => Future{ Thread.sleep(3500); i*i }
    }

    do{
      println("wait finish tasks")
      Thread.sleep(2000)
    }while(!traversed.isCompleted)
    println(traversed.value)

  }

}
