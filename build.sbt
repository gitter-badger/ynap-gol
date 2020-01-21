name := "gol"
version := "0.1"
scalaVersion := "2.13.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % "test"

addCommandAlias("fm", "all compile:scalafmt test:scalafmt")
addCommandAlias("cc", "all clean compile")
addCommandAlias("c", "compile")
addCommandAlias("r", "run")
addCommandAlias("t", "test")
addCommandAlias("to", "testOnly")