package com.phmb.myposts.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

import com.phmb.myposts.repository.APIService

import com.phmb.myposts.model.Post

class HomeViewModel : ViewModel() {

    var list: LiveData<List<Post>>

    init {
        list =  APIService.getUserList()
    }

    fun fetchAllData() : LiveData<List<Post>> = list

}