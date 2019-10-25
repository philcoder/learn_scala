package com.philipp.ch10.model

import scala.collection.mutable.ListBuffer

class Account(user:User, assetList: ListBuffer[Asset]) {
  override def toString: String = s"user: $user, assets = $assetList"
}
