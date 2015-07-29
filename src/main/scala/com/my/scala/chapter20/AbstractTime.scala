package com.my.scala.chapter20

/**
 * Declaring abstract vars
 */
trait AbstractTime {
  var hour: Int
  var minute: Int
}

/**
 * Shows how abstract vars are expanded into getter and setter
 */
trait AbstractTimeExplicit {
  def hour: Int         // getter for 'hour'
  def hour_= (x: Int)   // setter for 'hour'
  def minute: Int       // getter for 'minute'
  def minute_= (x: Int) // setter for 'minute'
}
