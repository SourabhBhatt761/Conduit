package com.srb.models.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.srb.models.entities.Article

@JsonClass(generateAdapter = true)
data class ArticleResponse(
        @Json(name = "article")
        val article: Article
)