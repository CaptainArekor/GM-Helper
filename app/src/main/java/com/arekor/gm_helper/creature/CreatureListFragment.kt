package com.arekor.gm_helper.creature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arekor.gm_helper.R
import com.arekor.gm_helper.data.model.Creature
import com.arekor.gm_helper.navigation.NavigationBarFragment
import kotlinx.android.synthetic.main.fragment_creature_list.*
import kotlinx.android.synthetic.main.fragment_creature_list.view.*
import org.jetbrains.anko.doAsync

class CreatureListFragment : Fragment() {

    lateinit var model: CreatureViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                view?.findNavController()?.navigateUp()
            }
        })

        // Get the view model )
        model = ViewModelProviders.of(requireActivity()).get(CreatureViewModel::class.java)

    }

    override fun onStart() {
        super.onStart()
        setNavigationBar()
    }

    private fun setNavigationBar() {
        val navigationBar = childFragmentManager.fragments.first() as NavigationBarFragment
        navigationBar.setTitle("CREATURES")
        navigationBar.showBackButton(true)
        navigationBar.showValidateButton(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_creature_list, container, false)

        val linearLayoutManager = LinearLayoutManager(
            context, RecyclerView.VERTICAL, false
        )

        val recyclerView = view?.findViewById<RecyclerView>(R.id.monster_list_recyclerview)
        recyclerView?.layoutManager = linearLayoutManager

        // Observe the model
        model.allMonsters.observe(viewLifecycleOwner, Observer { monsters ->
            // Data bind the recycler view
            monster_list_recyclerview.adapter =
                CreatureAdapter(monsters, this, view, requireActivity())
        })

        view.monster_list_add_monster.setOnClickListener {
            findNavController().navigate(R.id.monsterCreationFragment)
        }
        return view
    }
}