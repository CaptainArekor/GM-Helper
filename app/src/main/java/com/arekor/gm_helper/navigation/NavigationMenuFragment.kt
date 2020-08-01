package com.arekor.gm_helper.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.arekor.gm_helper.R
import kotlinx.android.synthetic.main.fragment_creature_list.view.*
import kotlinx.android.synthetic.main.fragment_navigation_menu.*
import kotlinx.android.synthetic.main.fragment_navigation_menu.view.*

class NavigationMenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_navigation_menu, container, false)
        view.open_monster_list.setOnClickListener{ openMonsterList() }
        view.test_open_dices.setOnClickListener{ openDice() }
        view.navigation_menu.visibility = View.GONE
        return view
    }

    override fun onStart() {
        super.onStart()
        setNavigationBar()
    }

    private fun setNavigationBar(){
        val navigationBar = childFragmentManager.fragments.first() as NavigationBarFragment
        navigationBar.setTitle(getString(R.string.app_name))
        navigationBar.showBackButton(false)
        navigationBar.showValidateButton(false)
    }

    private fun openMonsterList(){
        findNavController().navigate(R.id.monsterListFragment)
    }

    private fun openDice(){
        findNavController().navigate(R.id.diceFragment)
    }
}