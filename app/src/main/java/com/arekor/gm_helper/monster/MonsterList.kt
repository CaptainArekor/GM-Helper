package com.arekor.gm_helper.monster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.Observer
import com.arekor.gm_helper.R
import com.arekor.gm_helper.data.model.Monster
import kotlinx.android.synthetic.main.activity_monster_list.*
import org.jetbrains.anko.doAsync
import java.util.*

class MonsterList : AppCompatActivity() {

    private lateinit var model: MonsterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monster_list)

        // Get the view model
        model = ViewModelProviders.of(this).get(MonsterViewModel::class.java)

        // Specify layout for recycler view
        val linearLayoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL,false)
        monster_list_recyclerview.layoutManager = linearLayoutManager

        // Observe the model
        model.allMonsters.observe(this, Observer{ students->
            // Data bind the recycler view
            monster_list_recyclerview.adapter = MonsterAdapter(students)
        })

        // Insert data into table
        monster_list_add_monster.setOnClickListener {
            doAsync {
                model.insert(Monster(null, "Monstre"))
            }
        }
    }
}