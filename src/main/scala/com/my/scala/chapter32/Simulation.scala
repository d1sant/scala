package com.my.scala.chapter32

import scala.actors._
import scala.actors.Actor._

object Simulation {

  // TODO Make it work!!! )

  def main(args: Array[String]) {
    val circuit = new Circuit with Adders
    import circuit._
    val ain = new Wire("ain", true)
    val bin = new Wire("bin", false)
    val cin = new Wire("cin", true)
    val sout = new Wire("sout")
    val cout = new Wire("cout")
    prob(ain)
    prob(bin)
    prob(cin)
    prob(sout)
    prob(cout)
    fullAdder(ain, bin, cin, sout, cout)
    circuit.start()
  }
}

trait Simulant extends Actor {
  val clock: Clock
  def handleSimMessage(msg: Any)
  def simStarting() {}
  def act() {
    loop {
      react {
        case Stop => exit()
        case Ping(time) =>
          if (time == 1) simStarting()
          clock ! Pong(time, self)
        case msg => handleSimMessage(msg)
      }
    }
  }
  start()
}

class Circuit {

  val clock = new Clock

  // simulation messages
  case class SetSignal(sig: Boolean)
  case class SignalChanged(wire: Wire, sig: Boolean)

  // delay constants
  val WireDelay = 1
  val InverterDelay = 2
  val OrGateDelay = 3
  val AndGateDelay = 3

  // Wire and Gate classes and methods
  class Wire(name: String, init: Boolean) extends Simulant {
    def this(name: String) { this(name, false) }
    def this() { this("unnamed") }
    val clock = Circuit.this.clock
    clock.add(this)
    private var sigVal = init
    private var observers: List[Actor] = List()
    def handleSimMessage(msg: Any) {
      msg match {
        case SetSignal(s) =>
          if (s != sigVal) {
            sigVal = s
            signalObservers()
          }
      }
    }
    def signalObservers() {
      for (obs <- observers)
        clock ! AfterDelay(WireDelay, SignalChanged(this, sigVal), obs)
    }
    override def simStarting() { signalObservers() }
    def addObservers(obs: Actor) {
      observers = obs :: observers
    }
    override def toString = "Wire(" + name + ")"
  }
  private object DummyWire extends Wire("dummy")
  abstract class Gate(in1: Wire, in2: Wire, out: Wire) extends Simulant {
    def computeOutput(s1: Boolean, s2: Boolean): Boolean
    val delay: Int
    val clock = Circuit.this.clock
    clock.add(this)
    in1.addObservers(this)
    in2.addObservers(this)
    var s1, s2 = false
    override def handleSimMessage(msg: Any) {
      msg match {
        case SignalChanged(w, sig) =>
          if (w == in1)
            s1 = sig
          if (w == in2)
            s2 = sig
          clock ! AfterDelay(delay, SetSignal(computeOutput(s1, s2)), out)
      }
    }
  }

  // misc. utility methods
  def orGate(in1: Wire, in2: Wire, output: Wire) =
    new Gate(in1, in2, output) {
      val delay = OrGateDelay
      def computeOutput(s1: Boolean, s2: Boolean) = s1 || s2
    }
  def andGate(in1: Wire, in2: Wire, output: Wire) =
    new Gate(in1, in2, output) {
      val delay = AndGateDelay
      def computeOutput(s1: Boolean, s2: Boolean) = s1 && s2
    }
  def inverter(input: Wire, output: Wire) =
    new Gate(input, DummyWire, output) {
      val delay = InverterDelay
      def computeOutput(s1: Boolean, ignored: Boolean) = !s1
    }
  def prob(wire: Wire) = new Simulant {
    val clock = Circuit.this.clock
    clock.add(this)
    wire.addObservers(this)
    def handleSimMessage(msg: Any): Unit = {
      msg match {
        case SignalChanged(w, s) =>
          println("signal " + w + " changed to " + s)
      }
    }
  }
  def start() { clock ! Start }
}

trait Adders extends Circuit {
  def halfAdder(a: Wire, b: Wire, s: Wire, c: Wire) {
    val d, e = new Wire
    orGate(a, b, d)
    andGate(a, b, c)
    inverter(c, e)
    andGate(d, e, s)
  }
  def fullAdder(a: Wire, b: Wire, cin: Wire, sum: Wire, cout: Wire) {
    val s, c1, c2 = new Wire
    halfAdder(a, cin, s, c1)
    halfAdder(b, s, sum, c2)
    orGate(c1, c2, cout)
  }
}

case class Ping(time: Int)
case class Pong(time: Int, from: Actor)

class Clock extends Actor {
  private var running = false
  private var currentTime = 0
  private var agenda: List[WorkItem] = List()
  private var allSimulants: List[Actor] = List()
  private var busySimulants: Set[Actor] = Set.empty
  def add(sim: Simulant) {
    allSimulants = sim :: allSimulants
  }
  def act() {
    loop {
      if (running && busySimulants.isEmpty)
        advance()
      reactToOneMessage()
    }
  }
  def advance() {
    if (agenda.isEmpty && currentTime > 0) {
      println("** Agenda empty. Clock exiting at time " + currentTime + ".")
      self ! Stop
      return
    }
    currentTime += 1
    println("Advancing to time " + currentTime)
    processCurrentEvents()
    for (sim <- allSimulants)
      sim ! Ping(currentTime)
    busySimulants = Set.empty ++ allSimulants
  }
  private def processCurrentEvents() {
    val todoNow = agenda.takeWhile(_.time <= currentTime)
    agenda = agenda.drop(todoNow.length)
    for (WorkItem(time, msg, target) <- todoNow) {
      assert(time == currentTime)
      target ! msg
    }
  }
  def reactToOneMessage() {
    react {
      case AfterDelay(delay, msg, target) =>
        val item = WorkItem(currentTime + delay, msg, target)
        agenda = insert(agenda, item)
      case Pong(time, sim) =>
        assert(time == currentTime)
        assert(busySimulants contains sim)
        busySimulants -= sim
      case Start => running = true
      case Stop =>
        for (sim <- allSimulants)
          sim ! Stop
        exit()
    }
  }
  private def insert(ag: List[WorkItem], item: WorkItem): List[WorkItem] = {
    if (ag.isEmpty || item.time < ag.head.time) item :: ag
    else ag.head :: insert(ag.tail, item)
  }
}

case class WorkItem(time: Int, msg: Any, target: Actor)
case class AfterDelay(delay: Int, msg: Any, target: Actor)

case object Start
case object Stop
