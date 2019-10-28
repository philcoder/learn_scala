package com.philipp.ch12.model.adv

class MyQueue extends BasicIntQueue with Doubling with Filtering {
  //this case the compiler will call the method 'put(x: Int)' from trait and not from BasicIntQueue
}
