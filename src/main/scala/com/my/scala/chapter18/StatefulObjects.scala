package com.my.scala.chapter18

object StatefulObjects {

  def main(args: Array[String]) {

    val account = new BankAccount
    account deposit 100
    println(account withdraw 80)
    println(account withdraw 80)
  }
}
