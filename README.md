# JSONP filter for Play! framework

Enable JSONP on your API by using this filter.

## Installation

Add the following dependency and resolver to your build definition:

```scala
resolvers += "julienrf.github.com" at "http://julienrf.github.com/repo/"

libraryDependencies += "julienrf" %% "play-jsonp-filter" % "1.0-SNAPSHOT"
```

## Usage

Add the `julienrf.play.jsonp.Jsonp` filter to your `Global` object:

```scala
import play.api.mvc.WithFilters
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import julienrf.play.jsonp.Jsonp

object Global extends WithFilters(new Jsonp)
```

See the Scaladoc (online soon) for more information on the parameters you can pass to the `Jsonp` constructor.