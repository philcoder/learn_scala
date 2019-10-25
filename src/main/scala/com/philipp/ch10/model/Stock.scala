package com.philipp.ch10.model

//this class can't have subclass
private final class Stock(name:String, price:Double, quantity:Int, control:String = "ON") extends Asset(name,price,quantity){
  //Unit, PN or ON
  def getControl = control

  override def toString: String = f"Stock: $name/$control at $price with quantity: $quantity, total volume: $volume%.2f"
}
