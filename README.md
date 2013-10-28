# JSONP filter for Play! framework

This filter enables JSONP on your existing API: any resource that returns a JSON content will return a JavaScript fragment if there is an additional `callback` parameter in the query string.

For example, if the resource `/foo` gives the following JSON result: `{"foo": "bar"}`, the resource `/foo?callback=f` will give the following JavaScript result: `f({"foo": "bar"});`.

## Installation

Add the following dependency and resolver to your build definition:

```scala
resolvers += "julienrf.github.com" at "http://julienrf.github.com/repo-snapshots/"

libraryDependencies += "julienrf" %% "play-jsonp-filter" % "1.1-SNAPSHOT"
```

The `1.1-SNAPSHOT` version is compatible with Play 2.2.x.

## Usage

Add the `julienrf.play.jsonp.Jsonp` filter to your `Global` object:

```scala
import play.api.mvc.WithFilters
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import julienrf.play.jsonp.Jsonp

object Global extends WithFilters(new Jsonp)
```

See the [API documentation](http://julienrf.github.io/play-jsonp-filter/1.1-SNAPSHOT/api/) for more information on the parameters you can pass to the `Jsonp` constructor.
