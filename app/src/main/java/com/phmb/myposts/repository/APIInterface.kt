package com.phmb.myposts.repository

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path

import com.phmb.myposts.model.Post
import com.phmb.myposts.model.User

interface APIInterface {

    @GET("posts")
    fun getPosts(): Call<List<Post>>

    @GET("posts/{postId}")
    fun getPostById(@Path(value = "postId", encoded = true)  postId : Int): Call<Post>

    @GET("users/1")
    fun getUser(): Call<User>
}