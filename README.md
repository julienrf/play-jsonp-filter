# JSONP filter for Play! framework

This filter enables JSONP on your existing API: any resource that returns a JSON content will return a JavaScript fragment if there is an additional `callback` parameter in the query string.

For example, if the resource `/foo` gives the following JSON result: `{"foo": "bar"}`, the resource `/foo?callback=f` will give the following JavaScript result: `f({"foo": "bar"});`.

## Installation

Add the following dependency to your build definition:

```scala
libraryDependencies += "org.julienrf" %% "play-jsonp-filter" % "1.3"
```

The `1.3` version is compatible with Play 2.4.x.

## Usage
The simplest way to use a filter is to provide an implementation of the HttpFilters trait in the root package
~ https://www.playframework.com/documentation/2.4.x/ScalaHttpFilters

```scala
import play.api.mvc.WithFilters
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import julienrf.play.jsonp.Jsonp

import javax.inject.Inject
import julienrf.play.jsonp.Jsonp
import play.api.http.HttpFilters

class Filters @Inject()(jsonpFilter: Jsonp) extends HttpFilters {
  def filters = Seq(jsonpFilter)
}
```

# Changelog

- v1.3: support for Play 2.4.x ;
- v1.2: support for Play 2.3.x ;
- [v1.1](https://github.com/julienrf/play-jsonp-filter/tree/1.1): support for Play 2.2.x.

# License

This content is released under the [MIT License](http://opensource.org/licenses/mit-license.php).