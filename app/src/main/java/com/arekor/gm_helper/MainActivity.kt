package com.arekor.gm_helper

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.arekor.gm_helper.creature.CreatureViewModel

class MainActivity : AppCompatActivity() {

    lateinit var model: CreatureViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.TYPE_STATUS_BAR)
        setContentView(R.layout.activity_main)
    }
}