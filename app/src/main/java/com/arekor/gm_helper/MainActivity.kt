package com.arekor.gm_helper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arekor.gm_helper.creature.CreatureViewModel

class MainActivity : AppCompatActivity() {

    lateinit var model: CreatureViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}