package julienrf.play.jsonp

import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.mvc.Codec.utf_8

class JsonpJava extends Jsonp(Jsonp.DefaultParamName)(utf_8, defaultContext) {

}
