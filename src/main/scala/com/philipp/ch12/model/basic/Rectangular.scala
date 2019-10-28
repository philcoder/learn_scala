package com.philipp.ch12.model.basic

//rich interface, the fuctions can be implemented
trait Rectangular {
  //who's implements this trait need to create constructor with variables with same name and 'val'
  def topLeft: Point
  def bottomRight: Point

  //this attribute 'x' n object 'Point' can be accessed because 'val' keyword
  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
}
