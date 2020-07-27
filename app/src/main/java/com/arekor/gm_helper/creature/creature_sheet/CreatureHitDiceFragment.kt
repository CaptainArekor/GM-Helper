package com.arekor.gm_helper.creature.creature_sheet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import com.arekor.gm_helper.R
import kotlinx.android.synthetic.main.fragment_creature_armor_class.view.*
import kotlinx.android.synthetic.main.fragment_creature_hit_dice.view.*

class CreatureHitDiceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val hitView = inflater.inflate(R.layout.fragment_creature_hit_dice, container, false)

        // Set type spinner
        val diceAdapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.dices,
            android.R.layout.simple_spinner_item
        )
        diceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        hitView.creature_hit_dice_value.adapter = diceAdapter
        val defaultText = context?.resources?.getString(R.string.spinner_dice_20)
        hitView.creature_hit_dice_value.setSelection(diceAdapter.getPosition(defaultText))

        hitView.creature_hit_dice_amount.setOnFocusChangeListener{ view: View, b: Boolean ->
            if ((view as EditText).text != null) {
                if(view.text.isEmpty())
                    view.setText("1")
            }
        }

        return hitView
        //creature_hit_dice_value
    }
}