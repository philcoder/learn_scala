package com.philipp.other.model

class Temperature {
  var celsius:Float = _

  def fahrenheit = celsius * 9 / 5 + 32

  def fahrenheit_= (f: Float) = {
    celsius = (f - 32) * 5 / 9
  }

  override def toString =  s"$fahrenheit F/$celsius C"
}
