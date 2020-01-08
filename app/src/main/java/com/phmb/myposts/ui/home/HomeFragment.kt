package com.phmb.myposts.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View

import android.os.Bundle
import androidx.fragment.app.Fragment

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.phmb.myposts.R
import com.phmb.myposts.adapter.PostAdapter
import com.phmb.myposts.model.Post
import android.util.Log

import kotlinx.android.synthetic.main.home_fragment.userList

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    private lateinit var adapter : PostAdapter

    private var data: List<Post> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        userList.layoutManager = LinearLayoutManager(context)
        adapter = PostAdapter(context!!, data)
        userList.adapter = adapter

        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        viewModel.fetchAllData().observe(this,
            Observer<List<Post>> { listPost ->
                Log.v("users","users==" + listPost?.toString())
                adapter.addItems(listPost)
        })
    }

}