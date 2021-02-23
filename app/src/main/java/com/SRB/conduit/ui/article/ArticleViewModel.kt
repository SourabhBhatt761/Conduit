package com.SRB.conduit.ui.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.srb.ConduitClient
import com.srb.models.entities.Article
import kotlinx.coroutines.launch

class ArticleViewModel : ViewModel() {
    val api = ConduitClient.publicApi

    private val _article = MutableLiveData<Article>()
    val article: LiveData<Article> = _article

    fun fetchArticle(slug: String) = viewModelScope.launch {
        val response = api.getArticleBySlug(slug)

        response.body()?.article.let { _article.postValue(it) }

    }
}