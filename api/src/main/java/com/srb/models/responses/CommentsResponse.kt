package com.srb.models.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.srb.models.entities.Comment

@JsonClass(generateAdapter = true)
data class CommentsResponse(
        @Json(name = "comments")
        val comments: List<Comment>
)