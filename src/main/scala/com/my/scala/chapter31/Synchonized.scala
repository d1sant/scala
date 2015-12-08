package com.my.scala.chapter31

class Synchonized {
  def main(args: Array[String]) {
    var counter = 0
    synchronized {
      // One thread in here at a time
      counter = counter + 1
    }
  }
}
