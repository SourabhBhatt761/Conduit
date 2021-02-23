package com.srb.models.requsets

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.srb.models.entities.UserUpdateData


@JsonClass(generateAdapter = true)
data class UserUpdateRequest(
        @Json(name = "user")
        val user: UserUpdateData
)