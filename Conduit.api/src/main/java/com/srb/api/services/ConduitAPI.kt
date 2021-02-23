package com.srb.api.services

import com.srb.api.models.ArticleResponse
import retrofit2.http.GET

interface ConduitAPI {

@GET("articles")

    fun getArticles() : ArticleResponse
}