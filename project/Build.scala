import sbt._
import Keys._

import twirl.sbt.TwirlPlugin._

object Build extends Build {

  /**
   * A dummy aggregator project.
   */
  lazy val root = project.in(file(".")).aggregate(generator, sample)

  //val paradiseDependency = "org.scalamacros" % "paradise" % "2.0.0" cross CrossVersion.full

  lazy val generator = project.in(file("generator"))
    .settings(Twirl.settings:_*)
    .settings(
      libraryDependencies ++=Seq(
        "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.5.3",
        // AST generator dependencies
        "com.eed3si9n" %% "treehugger" % "0.4.3",
        // Macro generator dependencies
        "org.scala-lang" % "scala-reflect" % "2.11.8"//,
        //paradiseDependency
      ),//,
      //addCompilerPlugin(paradiseDependency),
      scalaVersion := "2.11.8"
    )

  lazy val sample = project.in(file("sample"))
    .dependsOn(generator)
    .settings(scalaVersion := "2.11.8"
//      addCompilerPlugin(paradiseDependency)
    )

}