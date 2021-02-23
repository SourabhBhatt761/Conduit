package com.srb.models.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.srb.models.entities.Comment

@JsonClass(generateAdapter = true)
data class CommentResponse(
        @Json(name = "comment")
        val comments: Comment
)