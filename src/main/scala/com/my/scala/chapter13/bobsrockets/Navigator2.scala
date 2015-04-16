package com.my.scala.chapter13.bobsrockets {
  package navigation5 {

    class Navigator2 {
      // No need to say bobsrocketes.navigation4.StarMap
      val map = new StarMap
    }

    class StarMap
  }
  class Ship {
    // No need to say bobsrocketes.navigation4.Navigator
    val nav = new navigation5.Navigator2
  }
  package fleets {
    class Fleet {
      // No need to say bobsrockets.Ship
      def addShip() { new Ship }
    }
  }
}
