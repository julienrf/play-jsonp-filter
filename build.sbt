name := "play-jsonp-filter"

organization := "org.julienrf"

version := "1.3"

crossScalaVersions := Seq("2.10.5", "2.11.6")

val playVersion = "2.4.2"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play" % playVersion
)

libraryDependencies += specs2 % Test

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

publishTo := {
  val nexus = "https://oss.sonatype.org"
  if (isSnapshot.value) Some("snapshots" at s"$nexus/content/repositories/snapshots")
  else Some("releases" at s"$nexus/service/local/staging/deploy/maven2")
}

pomExtra := (
  <url>http://github.com/julienrf/play-jsonp-filter</url>
  <licenses>
    <license>
      <name>MIT License</name>
      <url>http://opensource.org/licenses/mit-license.php</url>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:julienrf/play-jsonp-filter.git</url>
    <connection>scm:git:git@github.com:julienrf/play-jsonp-filter.git</connection>
  </scm>
  <developers>
    <developer>
      <id>julienrf</id>
      <name>Julien Richard-Foy</name>
      <url>http://julien.richard-foy.fr</url>
    </developer>
  </developers>
)

useGpg := true

lazy val sitePath = settingKey[File]("Path to the publishing site")

sitePath := Path.userHome / "sites" / "julienrf.github.com"

lazy val publishDoc = taskKey[Unit]("Publish the documentation")

publishDoc := IO.copyDirectory((doc in Compile).value, sitePath.value / "play-jsonp-filter" / version.value / "api")

PgpKeys.publishSigned := {
  PgpKeys.publishSigned.value
  publishDoc.value
}
