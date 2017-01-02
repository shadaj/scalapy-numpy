organization := "me.shadaj"

name := "scalapy-numpy"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.12.1"

fork in runMain := true

javaOptions in Test += "-Djava.library.path=./lib/"
javaOptions in runMain += "-Djava.library.path=./lib/"

libraryDependencies += "me.shadaj" %% "scalapy" % "0.1.0-SNAPSHOT"
