package julienrf.play.jsonp

import play.api.http.ContentTypes.{JAVASCRIPT, JSON}
import play.api.http.HeaderNames.CONTENT_TYPE
import play.api.libs.iteratee.Enumerator
import play.api.mvc.Codec._
import play.api.mvc._
import play.api.libs.concurrent.Execution.Implicits.defaultContext

/**
 * Transforms JSON responses into JavaScript responses if there is a `paramName` parameter in the request’s query string.
 *
 * See [[http://www.json-p.org/]] for more information about JSONP.
 */
class Jsonp extends EssentialFilter {

  val DefaultParamName = "callback"
  implicit val codec = utf_8

  def apply(action: EssentialAction) = EssentialAction { request =>
    val resultProducer = action(request)
    request.getQueryString(DefaultParamName) match {
      case Some(callback) => resultProducer.map(jsonpify(callback))
      case None => resultProducer
    }
  }

  /**
   * Tries to transform a response into a JavaScript expression.
   * @param callback JavaScript callback name
   * @param result Result to transform
   */
  def jsonpify(callback: String)(result: Result): Result =
    result.header.headers.get(CONTENT_TYPE) match {
      case Some(ct) if ct == JSON =>
        Result(
          header = result.header,
          body = Enumerator(codec.encode(s"$callback(")) >>> result.body >>> Enumerator(codec.encode(");")),
          connection = result.connection
        ).as(JAVASCRIPT)
      case _ => result
    }

}