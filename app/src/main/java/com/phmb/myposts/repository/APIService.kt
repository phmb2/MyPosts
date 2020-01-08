package com.phmb.myposts.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.Response

import retrofit2.converter.gson.GsonConverterFactory

import com.phmb.myposts.model.Post
import com.phmb.myposts.model.User
import com.phmb.myposts.helper.Utils

class APIService {

    companion object {

        var apiInterface: APIInterface

        init {
            val retrofit = Retrofit.Builder()
                .baseUrl(Utils.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            apiInterface = retrofit.create(APIInterface::class.java)
        }


        fun getPosts(): LiveData<List<Post>> {

            val data = MutableLiveData<List<Post>>()

            apiInterface.getPosts().enqueue(object : Callback<List<Post>> {
                override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    data.setValue(response.body())
                }

                override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                    data.setValue(null)
                    t.printStackTrace()
                }
            })

            return data
        }

        fun getPostById(id: Int): LiveData<Post> {

            val data = MutableLiveData<Post>()

            apiInterface.getPostById(id).enqueue(object : Callback<Post> {
                override fun onResponse(call: Call<Post>, response: Response<Post>) {
                    data.setValue(response.body())
                }

                override fun onFailure(call: Call<Post>, t: Throwable) {
                    data.setValue(null)
                    t.printStackTrace()
                }
            })

            return data
        }

        fun getUser(): LiveData<User> {

            val data = MutableLiveData<User>()

            apiInterface.getUser().enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    data.setValue(response.body())
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    data.setValue(null)
                    t.printStackTrace()
                }
            })

            return data
        }
    }
}