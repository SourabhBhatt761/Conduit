package com.srb.models.requsets

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.srb.models.entities.SignupData


@JsonClass(generateAdapter = true)
data class SignupRequest(
        @Json(name = "user")
        val user: SignupData
)