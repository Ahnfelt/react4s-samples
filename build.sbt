enablePlugins(ScalaJSPlugin)

name := "react4s-samples"
organization := "com.github.ahnfelt"
version := "0.1-SNAPSHOT"

resolvers += Resolver.sonatypeRepo("snapshots")
libraryDependencies += "com.github.ahnfelt" %%% "react4s" % "0.9.27-SNAPSHOT"
libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "1.0.0"
libraryDependencies += "com.github.werk" %%% "router4s" % "0.1.1-SNAPSHOT"

scalaVersion := "2.13.0"

scalaJSUseMainModuleInitializer := true
