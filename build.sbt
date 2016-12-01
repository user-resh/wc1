import sbt._

name := "wc1"

version := "1.0"

scalaVersion := "2.10.5"
libraryDependencies ++= Seq("org.apache.spark" %% "spark-core" % "1.6.0",
  "org.apache.spark" %% "spark-sql" % "1.6.0",
  "com.holdenkarau" %% "spark-testing-base" % "1.6.0_0.3.3")


 // "org.scalatest" % "scalatest_2.10" % "2.2.1" % "test")//,
// % "sbt-scoverage" % "1.0.1")

parallelExecution in Test := false

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.3.5")
coverageEnabled in Test := true
coverageExcludedPackages := "wc\\.main.*"
