package com.philipp.other.model

class Time {
  private[this] var h = 0
  private[this] var m = 0

  //convention to get
  def hour: Int = h
  //convention to set
  def hour_= (x: Int) = {
    require(0 <= x && x < 24)
    h = x
  }

  def minute = m
  def minute_= (x: Int) = {
    require(0 <= x && x < 60)
    m = x
  }

  override def toString: String = s"$h:$m"
}
