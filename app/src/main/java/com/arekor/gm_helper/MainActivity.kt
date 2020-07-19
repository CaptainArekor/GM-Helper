package com.arekor.gm_helper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arekor.gm_helper.monster.MonsterList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_open_monster_list.setOnClickListener(){
            var intent = Intent(this, MonsterList::class.java)
            startActivity(intent)
        }
    }
}