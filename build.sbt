organization := "me.shadaj"

name := "scalapy-numpy"

scalaVersion := "2.12.6"

fork in Test := true

javaOptions in Test += "-Djava.library.path=/usr/local/lib/python3.6/site-packages/jep"

libraryDependencies += "me.shadaj" %% "scalapy" % "2355a3e0"
