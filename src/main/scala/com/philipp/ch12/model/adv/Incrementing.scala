package com.philipp.ch12.model.adv

trait Incrementing extends IntQueue{
  abstract override def put(x: Int) = { super.put(x + 1) }
}
