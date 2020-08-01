package com.arekor.gm_helper.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.arekor.gm_helper.R
import kotlinx.android.synthetic.main.fragment_navigation_bar.view.*

class NavigationBarFragment : Fragment() {
    private lateinit var menuView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        menuView = inflater.inflate(R.layout.fragment_navigation_bar, container, false)
        menuView.navigation_back_button.setOnClickListener {onBackButton()}
        menuView.navigation_validate_button.setOnClickListener {
        }
        return menuView
    }

    private fun onBackButton(){
        val parent = parentFragmentManager.fragments.first() as Fragment
        parent.findNavController().navigateUp()
    }


    fun setTitle(title: String) {
        menuView.navigation_title.text = title
    }

    fun showBackButton(shown: Boolean) {
        if (shown)
            menuView.navigation_back_button.visibility = View.VISIBLE
        else
            menuView.navigation_back_button.visibility = View.GONE
    }

    fun showValidateButton(shown: Boolean){
        if (shown)
            menuView.navigation_validate_button.visibility = View.VISIBLE
        else
            menuView.navigation_validate_button.visibility = View.GONE
    }
}