package com.arekor.gm_helper.creature.creature_sheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.arekor.gm_helper.R
import kotlinx.android.synthetic.main.fragment_creature_sheet.view.*

class CreatureSheetFragment : Fragment() {

    lateinit var creatureView : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                creatureView.findNavController().navigateUp()
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        creatureView = inflater.inflate(R.layout.fragment_creature_sheet, container, false)
        creatureView.test_open_dices.setOnClickListener{findNavController().navigate(R.id.diceFragment)}
        return creatureView
    }
}