package com.phmb.myposts.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData

import com.phmb.myposts.model.Post
import com.phmb.myposts.repository.APIService

class DetailsViewModel(id: Int) : ViewModel() {

    var post: LiveData<Post> = APIService.getPostById(id)

    fun fetchPostById() : LiveData<Post> = post
}