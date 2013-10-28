name := "play-jsonp-filter"

organization := "julienrf"

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.1"

resolvers += "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "com.typesafe.play" %% "play" % "2.2.0"

libraryDependencies += "com.typesafe.play" %% "play-test" % "2.2.0" % "test"

publishTo <<= version {
  case v if v.trim.endsWith("SNAPSHOT") => Some(Resolver.file("Github Pages", Path.userHome / "sites" / "julienrf.github.com" / "repo-snapshots" asFile))
  case _ => Some(Resolver.file("Github Pages", Path.userHome / "sites" / "julienrf.github.com" / "repo" asFile))
}