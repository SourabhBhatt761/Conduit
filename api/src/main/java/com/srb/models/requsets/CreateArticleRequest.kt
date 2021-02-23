package com.srb.models.requsets


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.srb.models.entities.ArticleData


@JsonClass(generateAdapter = true)
data class CreateArticleRequest(
        @Json(name = "article")
        val article: ArticleData
)