# JSONP filter for Play! framework

This filter enables JSONP on your existing API: any resource that returns a JSON content will return a JavaScript fragment if there is an additional `callback` parameter in the query string.

For example, if the resource `/foo` gives the following JSON result: `{"foo": "bar"}`, the resource `/foo?callback=f` will give the following JavaScript result: `f({"foo": "bar"});`.

## Installation

Add the following dependency to your build definition:

```scala
libraryDependencies += "org.julienrf" %% "play-jsonp-filter" % "1.2"
```

The `1.2` version is compatible with Play 2.3.x.

## Usage

For Scala, add the `julienrf.play.jsonp.Jsonp` filter to your `Global` object:

```scala
import play.api.mvc.WithFilters
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import julienrf.play.jsonp.Jsonp

object Global extends WithFilters(new Jsonp)
```

For Java, add the `julienrf.play.jsonp.Jsonp` filter to your `Global` object:

```java

public class Global extends GlobalSettings {
    	@Override
	    public <T extends EssentialFilter> Class<T>[] filters() {
		      return new Class[] {julienrf.play.jsonp.JsonpJava.class};
		      //If Gzip is activated in your build.sbt, add always Gzip as the first filter in the list
		      //return new Class[] {GzipFilter.class, julienrf.play.jsonp.JsonpJava.class};
	    }
}
```

See the [API documentation](http://julienrf.github.io/play-jsonp-filter/1.2/api/) for more information on the parameters you can pass to the `Jsonp` constructor.

# Changelog

- v1.2: support for Play 2.3.x ;
- [v1.1](https://github.com/julienrf/play-jsonp-filter/tree/1.1): support for Play 2.2.x.

# License

This content is released under the [MIT License](http://opensource.org/licenses/mit-license.php).
