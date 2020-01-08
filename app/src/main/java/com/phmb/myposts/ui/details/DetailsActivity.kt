package com.phmb.myposts.ui.details

import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.phmb.myposts.R
import com.phmb.myposts.model.Post

import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailsViewModel
    lateinit var post: Post

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val id = DetailsActivityArgs.fromBundle(intent.extras!!).id
        val factory = CustomViewModelFactory(id)

        supportActionBar?.let {
            it.title = getString(R.string.post_detail)
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
        }

        viewModel = ViewModelProviders.of(this, factory).get(DetailsViewModel::class.java)

        viewModel.fetchPostById().observe(this,
            Observer<Post> { post ->
                Log.d("DetailsActivity", post?.title.toString())
                titlePost.text = post?.title
                descriptionPost.text = post?.body
            })
    }

    @Suppress("UNCHECKED_CAST")
    class CustomViewModelFactory(private val test: Int) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return DetailsViewModel(test) as T
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}