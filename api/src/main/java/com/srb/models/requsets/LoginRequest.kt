package com.srb.models.requsets

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.srb.models.entities.LoginData


@JsonClass(generateAdapter = true)
data class LoginRequest(
        @Json(name = "user")
        val user: LoginData
)