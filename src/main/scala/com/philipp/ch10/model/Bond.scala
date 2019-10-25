package com.philipp.ch10.model

//visible only inside package
private class Bond(name:String, price:Double, quantity:Int, rate:Double, years:Int) extends Asset(name,price,quantity) {
  //this method can't be override by your subclass
  final override def volume: Double = super.volume * math.pow((1+rate),years)

  def getRate = rate

  def getYears = years

  override def toString: String = f"Bond: $name at rate: $rate and manurity years: $years, total volume: $volume%.2f"
}
