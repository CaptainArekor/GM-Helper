package com.arekor.gm_helper.creature.creature_sheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.arekor.gm_helper.R
import kotlinx.android.synthetic.main.fragment_creature_sheet.view.*

class CreatureSheetFragment : Fragment() {

    lateinit var creatureView: View
    lateinit var model: CreatureSheetViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        model = ViewModelProviders.of(requireActivity()).get(CreatureSheetViewModel::class.java)

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
        creatureView.creature_sheet_save_button.setOnClickListener {
            if (model.checkMandatory()) {
                model.insert()
                creatureView.findNavController().navigateUp()
            }
        }
        return creatureView
    }
}