package com.phmb.myposts.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData

import com.phmb.myposts.model.User
import com.phmb.myposts.repository.APIService

class ProfileViewModel : ViewModel() {

    var post: LiveData<User> = APIService.getUser()

    fun fetchUser() : LiveData<User> = post
}