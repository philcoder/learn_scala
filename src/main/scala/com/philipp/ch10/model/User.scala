package com.philipp.ch10.model

class User(name:String, password:String) {
  override def toString: String = s"name: $name, pw:$password"
}
