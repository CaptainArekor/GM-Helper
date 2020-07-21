package com.arekor.gm_helper.monster

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arekor.gm_helper.R
import com.arekor.gm_helper.data.model.Monster
import kotlinx.android.synthetic.main.fragment_monster_list.*
import org.jetbrains.anko.doAsync

class MonsterListFragment : Fragment() {

    lateinit var model: MonsterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                view?.findNavController()?.navigateUp()
            }
        })

        // Get the view model )
        model = ViewModelProviders.of(this).get(MonsterViewModel::class.java)

        // Specify layout for recycler view
        val linearLayoutManager = LinearLayoutManager(
            context, RecyclerView.VERTICAL, false
        )
        var recyclerView = view?.findViewById<RecyclerView>(R.id.monster_list_recyclerview)
        recyclerView?.layoutManager = linearLayoutManager

        // Observe the model
        model.allMonsters.observe(this, Observer { monsters ->
            // Data bind the recycler view
            monster_list_recyclerview.adapter = MonsterAdapter(monsters)
        })

        // Insert data into table
        /*monster_list_add_monster.setOnClickListener {
            doAsync {
                model.insert(Monster(null, "Monstre"))
            }
        }*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_monster_list, container, false)
    }
}