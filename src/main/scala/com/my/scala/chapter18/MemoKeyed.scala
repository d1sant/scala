package com.my.scala.chapter18

/**
 * Even if we have var field in this class it's functional cause it returns the same value
 */
class MemoKeyed extends Keyed {
  private var keyCache: Option[Int] = None
  override def computeKey: Int = {
    if (!keyCache.isDefined) keyCache = Some(super.computeKey)
    keyCache.get
  }
}
