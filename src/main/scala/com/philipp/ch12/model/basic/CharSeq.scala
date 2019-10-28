package com.philipp.ch12.model.basic

//thin interface
trait CharSeq {
  def charAt(index: Int): Char
  def length(): Int
  def subSequence(start: Int, end: Int): CharSequence
  def toString(): String
}
