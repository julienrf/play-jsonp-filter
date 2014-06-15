name := "play-jsonp-filter"

organization := "julienrf"

version := "1.1-SNAPSHOT"

scalaVersion := "2.11.1"

crossScalaVersions := Seq("2.10.4", "2.11.1")

resolvers += "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/"

val playVersion = "2.3.0"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play" % playVersion,
  "com.typesafe.play" %% "play-test" % playVersion % "test"
)

lazy val sitePath = settingKey[File]("Path to the publishing site")

sitePath := Path.userHome / "sites" / "julienrf.github.com"

publishTo := {
  Some(Resolver.file("Github Pages", sitePath.value / (if (version.value.trim.endsWith("SNAPSHOT")) "repo-snapshots" else "repo") asFile))
}

lazy val publishDoc = taskKey[Unit]("Publish the documentation")

publish := {
  publish.value
  IO.copyDirectory((doc in Compile).value, sitePath.value / "play-jsonp-filter" / version.value / "api")
}
