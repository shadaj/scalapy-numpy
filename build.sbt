import sbtcrossproject.CrossPlugin.autoImport.{crossProject, CrossType}
import scala.sys.process._

organization in ThisBuild := "me.shadaj"

lazy val scala211Version = "2.11.12"
lazy val scala212Version = "2.12.11"
lazy val scala213Version = "2.13.2"
lazy val supportedScalaVersions = List(scala212Version, scala213Version)

scalaVersion in ThisBuild := scala213Version

addCommandAlias(
  "publishSignedAll",
  (scalaPyNumpy: ProjectDefinition[ProjectReference])
    .aggregate
    .map(p => s"+ ${p.asInstanceOf[LocalProject].project}/publishSigned")
    .mkString(";", ";", "")
)

lazy val scalaPyNumpy = project.in(file(".")).aggregate(
  scalaPyNumpyJVM,
  scalaPyNumpyNative
).settings(
  publish := {},
  publishLocal := {},
  scalaSource in Compile := baseDirectory.value / "no-src",
  scalaSource in Test := baseDirectory.value / "no-src"
)

lazy val scalaPyNumpyCross = crossProject(JVMPlatform, NativePlatform)
  .crossType(CrossType.Pure)
  .in(file("."))
  .settings(
    name := "scalapy-numpy",
    libraryDependencies += "me.shadaj" %%% "scalapy-core" % "0.3.0+31-94930a4d",
  ).jvmSettings(
    crossScalaVersions := supportedScalaVersions,
    libraryDependencies += "org.scalatest" %%% "scalatest" % "3.1.0" % Test,
    libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.0" % Test,
    fork in Test := true,
    javaOptions in Test += s"-Djna.library.path=${"python3-config --prefix".!!.trim}/lib"
  ).nativeSettings(
    scalaVersion := scala211Version,
    libraryDependencies += "org.scalatest" %%% "scalatest" % "3.1.0-SNAP8" % Test,
    libraryDependencies += "com.github.lolgab" %%% "scalacheck" % "1.14.1" % Test,
    nativeLinkStubs := true,
    nativeLinkingOptions ++= {
      import scala.sys.process._
      "python3-config --ldflags".!!.split(' ').map(_.trim).filter(_.nonEmpty).toSeq
    }
  )

lazy val scalaPyNumpyJVM = scalaPyNumpyCross.jvm
lazy val scalaPyNumpyNative = scalaPyNumpyCross.native
