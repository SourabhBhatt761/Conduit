package com.srb.services

import com.srb.models.requsets.LoginRequest
import com.srb.models.requsets.SignupRequest
import com.srb.models.responses.ArticleResponse
import com.srb.models.responses.ArticlesResponse
import com.srb.models.responses.TagsResponse
import com.srb.models.responses.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface ConduitAPI {

    @POST("users")
    suspend fun signupUser(
            @Body userCreds: SignupRequest
    ): Response<UserResponse>

    @POST("users/login")
    suspend fun loginUser(
            @Body userCreds: LoginRequest
    ): Response<UserResponse>

    @GET("articles")
    suspend fun getArticles(
            @Query("author") author: String? = null,
            @Query("favourited") favourited: String? = null,
            @Query("tag") tag: String? = null
    ): Response<ArticlesResponse>

    @GET("articles/{slug}")
    suspend fun getArticleBySlug(
            @Path("slug") slug: String
    ): Response<ArticleResponse>

    @GET("tags")
    suspend fun getTags(): Response<TagsResponse>

}