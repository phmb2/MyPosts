package com.phmb.myposts.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import com.phmb.myposts.ui.home.HomeFragmentDirections

import com.phmb.myposts.R
import com.phmb.myposts.model.Post

import kotlinx.android.synthetic.main.post_item.view.title
import kotlinx.android.synthetic.main.post_item.view.description

class PostAdapter (private val context: Context, var data : List<Post>?) : RecyclerView.Adapter<PostAdapter.Holder>() {

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindItems(data?.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val v = LayoutInflater.from(context).inflate(R.layout.post_item, parent, false)
        return Holder(v)
    }

    override fun getItemCount(): Int = data?.size?:0

    fun addItems(post: List<Post>?) {
        data = post
        notifyDataSetChanged()
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItems(user: Post?){
            itemView.title.text =  user?.title
            itemView.description.text = user?.body

            itemView.setOnClickListener {
                val direction = HomeFragmentDirections.openDetails(user!!.id)
                findNavController(itemView).navigate(direction)
            }
        }
    }

}