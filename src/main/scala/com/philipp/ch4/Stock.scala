package com.philipp.ch4

//normal class with two attributes
class Stock(ticker:String, price:Double) {
  override def toString() : String = {
    return s"Ticker: $ticker value $price"
  }
}
