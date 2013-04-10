name := "play-jsonp-filter"

organization := "julienrf"

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.1"

resolvers += "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "play" %% "play" % "2.1.1"

libraryDependencies += "play" %% "play-test" % "2.1.1" % "test"

publishTo <<= version {
  case v if v.trim.endsWith("SNAPSHOT") => Some(Resolver.file("Github Pages", Path.userHome / "sites" / "julienrf.github.com" / "repo-snapshots" asFile))
  case _ => Some(Resolver.file("Github Pages", Path.userHome / "sites" / "julienrf.github.com" / "repo" asFile))
}