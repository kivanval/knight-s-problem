val scala3Version = "3.3.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "knight-s-problem",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "com.github.rssh" %% "dotty-cps-async" % "0.9.19",
    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test
  )
