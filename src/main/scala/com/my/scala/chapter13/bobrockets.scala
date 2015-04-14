package bobsrockets2 {
  package navigation {

  package launch {
      class Booster1
    }
    class MissionControl {
      val booster1 = new launch.Booster1
      val booster2 = new bobsrockets2.launch.Booster2
      val booster3 = new _root_.com.my.scala.chapter13.launch.Booster3
    }
  }
  package launch {
    class Booster2
  }
}
