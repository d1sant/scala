name := "scala"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"

libraryDependencies += "junit" % "junit" % "4.8.1" % "test"

libraryDependencies += "org.testng" % "testng" % "6.2" % "test"

libraryDependencies += "org.scala-tools.testing" % "specs_2.10" % "1.6.9" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.12.2" % "test"

libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.0.2"

// libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4-SNAPSHOT"

libraryDependencies += "org.scala-lang" % "scala-actors" % "2.11.7"

libraryDependencies ++= Seq("junit" % "junit" % "4.8.1" % "test")

// resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"
