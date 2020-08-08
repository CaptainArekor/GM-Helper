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
        view.menu_02.setOnClickListener {
            println("Menu 02")
        }
        view.menu_03.setOnClickListener {
            println("Menu 03")
        }
        /*Picasso.get()
            .load(R.drawable.background_image_forest)
            .transform(BlurTransformation(context, 50, 1))
            .centerCrop()
            .fit()
            .into(view.navigation_menu_background)*/
        return view
    }

    override fun onStart() {
        super.onStart()
        //setNavigationBar()
    }

    private fun setNavigationBar() {
        val navigationBar = childFragmentManager.fragments.first() as NavigationBarFragment
        navigationBar.setTitle(getString(R.string.app_name))
        navigationBar.showBackButton(false)
        navigationBar.showValidateButton(false)
    }

    private fun toastMe(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    private fun openMonsterList() {
        findNavController().navigate(R.id.monsterListFragment)
    }

    private fun openDice() {
        findNavController().navigate(R.id.diceFragment)
    }
}