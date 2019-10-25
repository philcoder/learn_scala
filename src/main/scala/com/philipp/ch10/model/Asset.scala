package com.philipp.ch10.model

//object factory for create object
object Asset{
  def instanceStock(name:String, price:Double, quantity:Int, control:String = "ON"): Asset = new Stock(name,price,quantity,control)

  def instanceBond(name:String, price:Double, quantity:Int, rate:Double, years:Int): Asset = new Bond(name,price,quantity,rate,years)
}

abstract class Asset(name:String,price:Double,quantity:Int){
  def volume = price * quantity

  def getName = name

  def getPrice = price

  def getQuantity = quantity
}
