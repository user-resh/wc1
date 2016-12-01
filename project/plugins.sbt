logLevel := Level.Warn
resolvers += Resolver.url("jetbrains-bintray", url("https://dl.bintray.com/jetbrains/sbt-plugins/"))(Resolver.ivyStylePatterns)
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.3.5")