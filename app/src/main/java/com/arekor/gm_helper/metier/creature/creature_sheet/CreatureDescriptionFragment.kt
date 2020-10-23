package com.arekor.gm_helper.metier.creature.creature_sheet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.arekor.gm_helper.R
import kotlinx.android.synthetic.main.fragment_creature_description.view.*

class CreatureDescriptionFragment : Fragment() {

    lateinit var creatureView : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        creatureView = inflater.inflate(R.layout.fragment_creature_description, container, false)
        // Set size spinner
        val sizeAdapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.creature_size,
            android.R.layout.simple_spinner_item
        )
        sizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        creatureView.creature_sheet_size_spinner.adapter = sizeAdapter
        val defaultSizeText = context?.resources?.getString(R.string.spinner_size_medium)
        creatureView.creature_sheet_size_spinner.setSelection(sizeAdapter.getPosition(defaultSizeText))

        // Set type spinner
        val typeAdapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.creature_type,
            android.R.layout.simple_spinner_item
        )
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        creatureView.creature_sheet_type_spinner.adapter = typeAdapter
        val defaultText = context?.resources?.getString(R.string.spinner_type_humanoid)
        creatureView.creature_sheet_type_spinner.setSelection(typeAdapter.getPosition(defaultText))

        // Set alignment spinner
        val alignmentAdapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.creature_alignment,
            android.R.layout.simple_spinner_item
        )
        alignmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        creatureView.creature_sheet_alignment_spinner.adapter = alignmentAdapter
        val defaultAlignmentText = context?.resources?.getString(R.string.spinner_alignment_unaligned)
        creatureView.creature_sheet_alignment_spinner.setSelection(alignmentAdapter.getPosition(defaultSizeText))
        return creatureView
    }
}