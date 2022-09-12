ThisBuild / scalaVersion := "2.13.8"

ThisBuild / version := "1.0-SNAPSHOT"

val circeVersion = "0.14.1"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """prueba_scala_1""",
    libraryDependencies ++= Seq(
      guice,
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test,
    ),
    libraryDependencies ++= Seq(
      "io.circe" %% "circe-core",
      "io.circe" %% "circe-generic",
      "io.circe" %% "circe-parser"
    ).map(_ % circeVersion),
    libraryDependencies ++= Seq(
      "com.typesafe.play" %% "play-slick" % "5.0.2",
      "com.typesafe.play" %% "play-slick-evolutions" % "5.0.2"
    ),
    libraryDependencies += "org.sangria-graphql" %% "sangria-circe" % "1.3.2",
    libraryDependencies += "org.postgresql" % "postgresql" % "42.5.0"

  )