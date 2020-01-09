package com.phmb.myposts

import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.bottomTab

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNavigation()
    }

    private fun initNavigation() {
        val controller = Navigation.findNavController(this, R.id.container)
        NavigationUI.setupWithNavController(bottomTab, controller)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.container).navigateUp()
    }

}
