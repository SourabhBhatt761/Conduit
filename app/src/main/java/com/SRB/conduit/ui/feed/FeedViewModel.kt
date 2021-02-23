package com.SRB.conduit.ui.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.SRB.conduit.data.ArticlesRepo
import com.srb.models.entities.Article
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {


    private val _feed = MutableLiveData<List<Article>>()
    val feed: LiveData<List<Article>> = _feed

    fun fetchGlobalFeed() = viewModelScope.launch {
        ArticlesRepo.getGlobalFeed()?.let {
            _feed.postValue(it)
        }

    }

    fun fetchMyFeed() = viewModelScope.launch {
        ArticlesRepo.getMyFeed()?.let {
            _feed.postValue(it)
        }
    }

}
