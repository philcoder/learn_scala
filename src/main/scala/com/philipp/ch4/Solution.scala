package com.philipp.ch4

class Solution {
  def exec()={

    //call a companion object is a singleton call
    println(ChecksumAccumulator.calculate("testando CSum"))
    println(ChecksumAccumulator.calculate("calcule CSum"))

    val stock = new Stock("BBAS3", 45.60)
    println(stock)
  }
}
