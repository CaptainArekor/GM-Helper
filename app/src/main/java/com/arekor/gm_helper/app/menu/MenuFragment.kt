package com.arekor.gm_helper.app.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.arekor.gm_helper.R
import kotlinx.android.synthetic.main.fragment_menu.view.*

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val menuView = inflater.inflate(R.layout.fragment_menu, container, false)
        menuView.menu_creature_button.setOnClickListener{
            findNavController().navigate(R.id.action_menuFragment_to_creatureListFragment)
        }
        return menuView
    }

}