package com.arekor.gm_helper.monster.monster_creation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.activity.OnBackPressedCallback
import androidx.navigation.findNavController
import com.arekor.gm_helper.R
import kotlinx.android.synthetic.main.fragment_monster_creation.*
import kotlinx.android.synthetic.main.fragment_monster_creation.view.*

class MonsterCreationFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                view?.findNavController()?.navigateUp()
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_monster_creation, container, false)
        val adapter = ArrayAdapter.createFromResource(requireContext(),R.array.monster_size, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        view.monster_creation_size_spinner.adapter = adapter
        return view
    }
}