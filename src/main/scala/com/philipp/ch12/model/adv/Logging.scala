package com.philipp.ch12.model.adv

trait Logging extends  IntQueue {
  abstract override def put(x: Int) = {
    println(s"logging value: $x before 'put'call")
    super.put(x)
    println("logging after call")
  }
}
