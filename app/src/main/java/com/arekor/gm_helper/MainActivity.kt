package com.arekor.gm_helper

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.arekor.gm_helper.creature.CreatureViewModel
import kotlinx.android.synthetic.main.activity_main.*
import com.arekor.gm_helper.R


class MainActivity : AppCompatActivity() {

    lateinit var model: CreatureViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun setUpNavigation() {
        val navHostFragment = Navigation.findNavController(
            this,
            fragment_container.id
        )
    }
}