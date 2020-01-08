package com.phmb.myposts.ui.profile

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View

import android.os.Bundle
import androidx.fragment.app.Fragment

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.phmb.myposts.R
import com.phmb.myposts.model.User
import android.util.Log

import kotlinx.android.synthetic.main.profile_fragment.name
import kotlinx.android.synthetic.main.profile_fragment.email
import kotlinx.android.synthetic.main.profile_fragment.phone
import kotlinx.android.synthetic.main.profile_fragment.address

class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.profile_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ProfileViewModel::class.java)

        viewModel.fetchUser().observe(this, Observer<User> {
            user ->
                Log.v("users", "users==" + user)
                setDataOnUI(user)
        })

    }

    @SuppressLint("SetTextI18n")
    private fun setDataOnUI(user: User?) {
        user?.let {
            name.text = it.name
            email.text = it.email
            phone.text = it.phone
            address.text = it.address.suite + ", " + it.address.street+ ", " +
                    it.address.city+ " - " + it.address.zipcode
        }
    }

}