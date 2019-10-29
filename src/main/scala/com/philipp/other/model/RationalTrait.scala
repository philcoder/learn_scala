package com.philipp.other.model

trait RationalTrait {
  val numerator: Int
  val denominator: Int

  require(denominator != 0)

  override def toString = s"$numerator/$denominator"
}
