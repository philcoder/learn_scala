package com.philipp.ch12.model.adv

//PS: the supertype can be a abstract class
trait Doubling extends IntQueue {
  //need abstract override because method is from abstract object
  abstract override def put(x: Int): Unit = {super.put(x * 2)}
}
