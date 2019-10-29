package com.philipp.ch6

//Rational number [numerator / denominator]
class Rational(numerator: Int, denominator: Int) {
  require(denominator != 0) //if false required will throws IllegalArgumentException.

  //on after constructor is called that attributes
  val num: Int = numerator
  val denom: Int = denominator
  //private attribute and call from java class
  private val gcd = new Calculator().gcd(numerator.abs, denominator.abs)

  // auxiliary constructor
  def this(numerator:Int) = this(numerator,1)

  //you need to use 'num', because 'numerator' is not visible outside class
  def add(that: Rational): Rational = {
    new Rational(num * that.denom + that.num * denom, denom * that.denom )
  }

  def + (that: Rational): Rational = add(that)

  def - (that: Rational): Rational = new Rational(num * that.denom - that.num * denom, denom * that.denom)

  def - (i: Int): Rational = new Rational(num - i * denom, denom)

  def * (that: Rational): Rational = new Rational(num * that.num, denom * that.denom)

  def * (i: Int): Rational = new Rational(num * i, denom)

  def / (that: Rational): Rational = new Rational(num * that.denom, denom * that.num)

  def lessThan(that: Rational) = this.num * that.denom < that.num * this.denom

  def max(that: Rational) = if (lessThan(that)) that else this

  //private function
  //private def gcdCalcule(a: Int, b: Int): Int = if (b == 0) a else gcdCalcule(b, a % b)

  override def equals(other: Any): Boolean =
    other match {
      case that: Rational =>
        (that canEqual this) &&
          num == that.num &&
          denom == that.denom
      case _ => false
    }

  private def canEqual(other: Any): Boolean = other.isInstanceOf[Rational]

  override def hashCode: Int = (num, denom).##

  override def toString = s"Rational = $numerator/$denominator, gcd: $gcd"
}
