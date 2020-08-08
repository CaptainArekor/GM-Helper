package com.arekor.gm_helper.navigation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.arekor.gm_helper.R
import kotlinx.android.synthetic.main.fragment_navigation_menu.view.*

class NavigationMenuFragment : Fragment() {

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_navigation_menu, container, false)
        view.menu_dice.setOnClickListener {
            openDice()
        }
        view.menu_creatures.setOnClickListener {
            openMonsterList()
        }
        view.menu_group.setOnClickListener {
            openGroupList()
        }
        view.menu_item.setOnClickListener {
            openItemList()
        }
        return view
    }

    private fun openMonsterList() {
        findNavController().navigate(R.id.monsterListFragment)
    }
    private fun openGroupList() {
        //findNavController().navigate(R.id.monsterListFragment)
        Toast.makeText(context,"Group",Toast.LENGTH_SHORT).show()
    }
    private fun openItemList() {
        //findNavController().navigate(R.id.monsterListFragment)
        Toast.makeText(context,"Item",Toast.LENGTH_SHORT).show()
    }
    private fun openDice() {
        findNavController().navigate(R.id.diceFragment)
    }
}