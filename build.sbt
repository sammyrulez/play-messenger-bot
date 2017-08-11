name := "play-messenger-bot"

organization := "org.github.sammyrulez"

version := "1.0"

scalaVersion := "2.12.1"

resolvers += Resolver.typesafeRepo("releases")

resolvers += "Bintary JCenter" at "http://jcenter.bintray.com"

libraryDependencies += "com.typesafe.play" %% "play" % "2.6.2"

libraryDependencies += "com.typesafe.play" %% "play-test" % "2.6.2" % "test"

libraryDependencies += ws

libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.1" % "test"

libraryDependencies += "play-circe" %% "play-circe" % "2608.3"

publishTo := Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/.m2/repository")))



