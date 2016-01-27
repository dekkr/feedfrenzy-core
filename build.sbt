lazy val commonSettings = Seq(
  organization := "dekkR projects",
  version := "0.0.2",
  scalaVersion := "2.11.6"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "feedfrenzy-core"
  )
  .enablePlugins(BuildInfoPlugin).settings(
  buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
  buildInfoPackage := "hello"
)

libraryDependencies ++= {
  val akkaV = "2.3.10"
  val akkaStreamV = "1.0-M5"
  val activateVersion = "1.7"
  val scalaLoggingVersion = "3.1.0"
  val slf4jVersion = "1.7.10"
  val logbackVersion = "1.1.2"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.typesafe.akka" %% "akka-testkit" % akkaV % "test",
    "com.typesafe.akka" %% "akka-stream-experimental" % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-core-experimental" % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-experimental" % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-testkit-experimental" % akkaStreamV % "test",
    "commons-validator" % "commons-validator" % "1.4.1",
    "org.scalaj" %% "scalaj-http" % "0.3.16",
    "org.specs2" %% "specs2-core" % "2.3.13" % "test",
    "com.typesafe.scala-logging" %% "scala-logging" % scalaLoggingVersion,
    "org.slf4j" % "slf4j-api" % slf4jVersion,
    "ch.qos.logback" % "logback-classic" % logbackVersion
  )
}

testOptions in Test += Tests.Argument("-oD")

//coverageExcludedPackages := ".*BuildInfo.*;.*BootedCore.*;.*Boot.*"
//coverageMinimum := 80
//coverageFailOnMinimum := true

Revolver.settings

scalacOptions in ThisBuild ++= Seq(Opts.compile.deprecation, Opts.compile.unchecked) ++
  Seq("-Ywarn-unused-import", "-Ywarn-unused", "-Xlint", "-feature")

// Seq(buildInfoSettings:_*)

// sourceGenerators in Compile <+= buildInfo

// buildInfoKeys := Seq[BuildInfoKey](version)
//
// buildInfoPackage := "feedfrenzy_core"

publishMavenStyle := true

licenses := Seq(
  ("MIT", url(s"https://github.com/dekkr/${name.value}/blob/${version.value}/LICENSE")))

  bintrayOrganization := Some("dekkr")

  bintrayRepository  := "feedr"

  bintrayPackageLabels := Seq("microservice", "scraping")


assemblyJarName in assembly := s"${name.value}-assembly-${version.value}.jar"

//assemblyMergeStrategy in assembly := {
//  case x if x.contains("org/apache/commons/collections") => MergeStrategy.first
//  case x if x.contains("com/esotericsoftware/minlog/") => MergeStrategy.first
//  case x if x.contains("org/xmlpull/v1/XmlPullParser") => MergeStrategy.first
//  case x =>
//    val oldStrategy = (assemblyMergeStrategy in assembly).value
//    oldStrategy(x)
//}

pomExtra :=
  <url>http://dekkr.nl</url>
    <licenses>
      <license>
        <name>MIT</name>
        <url>https://github.com/dekkr/${name.value}/blob/${version.value}/LICENSE</url>
      </license>
    </licenses>
    <developers>
      <developer>
        <id>plamola</id>
        <name>Matthijs Dekker</name>
        <email>projects@dekkr.nl</email>
        <organization>dekkR.nl</organization>
        <organizationUrl>http://dekkr.nl</organizationUrl>
      </developer>
    </developers>
    <scm>
      <connection>scm:git:git@github.com:dekkr/{name.value}.git</connection>
      <developerConnection>scm:git:git@github.com:dekkr/{name.value}.git</developerConnection>
      <url>git@github.com:dekkr/{name.value}.git</url>
    </scm>
