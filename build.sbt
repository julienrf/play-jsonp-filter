name := "play-jsonp-filter"

organization := "julienrf"

version := "1.1-SNAPSHOT"

scalaVersion := "2.10.2"

resolvers += "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "com.typesafe.play" %% "play" % "[2.2.0,)"

libraryDependencies += "com.typesafe.play" %% "play-test" % "[2.2.0,)" % "test"

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
