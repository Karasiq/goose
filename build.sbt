lazy val commonSettings = Seq(
  organization := "com.github.karasiq",
  version := "2.1.29",
  isSnapshot := version.value.endsWith("SNAPSHOT"),
  scalaVersion := "2.12.3",
  crossScalaVersions := Seq("2.11.11", scalaVersion.value),
  libraryDependencies ++= Seq(
    "org.apache.httpcomponents" % "httpclient" % "4.1.3",
    "commons-lang" % "commons-lang" % "2.6",
    "commons-io" % "commons-io" % "2.0.1",
    "org.jsoup" % "jsoup" % "1.7.3",
    "junit" % "junit" % "4.8.1" % "test",
    "org.slf4j" % "slf4j-api" % "1.6.1" % "compile",
    "org.slf4j" % "slf4j-log4j12" % "1.6.1" % "test",
    "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.6"
  )
)

lazy val publishSettings = Seq(
  publishMavenStyle := true,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases" at nexus + "service/local/staging/deploy/maven2")
  },
  publishArtifact in Test := false,
  pomIncludeRepository := { _ ⇒ false },
  licenses := Seq("Apache License, Version 2.0" → url("http://opensource.org/licenses/Apache-2.0")),
  homepage := Some(url("https://github.com/Karasiq/goose")),
  pomExtra := <scm>
    <url>git@github.com:Karasiq/goose.git</url>
    <connection>scm:git:git@github.com:Karasiq/goose.git</connection>
  </scm>
    <developers>
      <developer>
        <id>karasiq</id>
        <name>Piston Karasiq</name>
        <url>https://github.com/Karasiq</url>
      </developer>
    </developers>
)

lazy val goose = (project in file("."))
  .settings(commonSettings, publishSettings, name := "goose")