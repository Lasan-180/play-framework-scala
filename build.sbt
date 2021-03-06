import scala.math.Numeric.BigDecimalAsIfIntegral.mkNumericOps

name := """please"""
organization := "com.group"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.6"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.group.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.group.binders._"


/**These are the dependencies that it necessary to be specified in order to establish mysql database connection*/
libraryDependencies ++= Seq(
  jdbc
)
libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "5.1.41"
)

