package com.philipp.other

import com.philipp.other.model.{BankAccount, RationalTrait, Temperature, Time}

object MutableObject {
  def main(args: Array[String]): Unit = {
    runBankAcc
    runTime
    runTemperature
  }

  def runBankAcc = {
    val acc = new BankAccount
    acc deposit 1000
    println(acc)
    acc withdraw 450
    println(acc)
  }

  def runTime ={
    val time = new Time
    time.hour = 12
    //you didn't need to call minute_= when attr variable
    time.minute = 45

    println(time)
  }

  def runTemperature ={
    val temp = new Temperature
    temp.fahrenheit = 50
    println(temp)
    temp.celsius = 15
    println(temp)
  }

  def instanceOfTrait ={
    //anonymous class
    new RationalTrait {
      val numerator = 1
      val denominator = 5
    }
  }

}
