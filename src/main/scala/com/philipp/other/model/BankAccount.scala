package com.philipp.other.model

//example mutable object
class BankAccount {
  private var money: Int = 0

  def balance: Int = money

  def deposit(amount: Int) = {
    //protect against negative values and throws IllegalArgumentException if false
    require(amount > 0)
    money += amount
  }

  def withdraw(amount: Int): Boolean = {
    if (amount > money) false
    else {
      money -= amount
      true
    }
  }

  override def toString: String = s"Account balance: $money"
}
