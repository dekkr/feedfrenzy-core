package nl.dekkr.feedfrenzy.core.services

import nl.dekkr.feedfrenzy.core.model.{BackendResult, PageUrl}

trait BackendSystem {


  def getArticles(request: PageUrl): BackendResult
  def getArticle(request: PageUrl): BackendResult

}
