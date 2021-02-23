package com.SRB.conduit.data

import com.srb.ConduitClient

object ArticlesRepo {
    val api = ConduitClient.publicApi
    val authApi = ConduitClient.authApi

    suspend fun getGlobalFeed() = api.getArticles().body()?.articles
    suspend fun getMyFeed() = authApi.getFeedArticles().body()?.articles
}