package nl.dekkr.feedfrenzy.core.services

import nl.dekkr.feedfrenzy.core.model._

import scala.util.{ Failure, Success, Try }
import scalaj.http.Http

class BackendService(pagefetcher_uri: String) extends BackendSystem {

  private val USER_AGENT: String = "feedfrenzy-backend"
  private val CHARSET: String = "UTF-8"

  def getArticles(request: PageUrl): BackendResult = {
    Try(this.pageContent(request.url).charset(CHARSET)) match {
      case Success(content) =>
        processRequest(request, content)
      case Failure(e) => Error(s"${e.getMessage}")
    }
  }

  def getArticle(request: PageUrl): BackendResult = {
    Try(this.pageContent(request.url).charset(CHARSET)) match {
      case Success(content) =>
        processRequest(request, content)
      case Failure(e) => Error(s"${e.getMessage}")
    }
  }

  private def processRequest(request: PageUrl, content: Http.Request): BackendResult = {
    NewContent(content.asString)
  }

  private def pageContent(uri: String) = Http(pagefetcher_uri + uri).header("User-Agent", USER_AGENT)

}
