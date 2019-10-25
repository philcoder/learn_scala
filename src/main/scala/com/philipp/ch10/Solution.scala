package com.philipp.ch10

import com.philipp.ch10.model.{Account, Asset, Stock, User}

import scala.collection.mutable.ListBuffer

class Solution {
  def exec()={
    val user = new User("Philipp", "tes.123")
    val assets = new ListBuffer[Asset]()
    assets.append(Asset.instanceStock("PETR4",29.00,2500))
    assets.append(Asset.instanceStock("BPAN4",12.50,3000,"PN"))
    assets.append(Asset.instanceStock("CIEL3",9.00,4500))
    assets.append(Asset.instanceBond("LTN 15052022", 850.98, 75, 0.0875, 3))
    assets.append(Asset.instanceBond("NTN 15052024", 2391.68, 210, 0.0565, 4))

    val acc = new Account(user, assets)
    println(acc)
  }
}
