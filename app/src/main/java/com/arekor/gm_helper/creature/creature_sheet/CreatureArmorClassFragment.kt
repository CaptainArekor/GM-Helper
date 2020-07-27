package com.arekor.gm_helper.creature.creature_sheet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.arekor.gm_helper.R
import kotlinx.android.synthetic.main.fragment_creature_armor_class.view.*
import kotlinx.android.synthetic.main.fragment_creature_statistics.view.*

class CreatureArmorClassFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var armorView = inflater.inflate(R.layout.fragment_creature_armor_class, container, false)
        armorView.creature_armor_class.setOnFocusChangeListener{ view: View, b: Boolean ->
            if ((view as EditText).text != null) {
                if(view.text.isEmpty())
                    view.setText("0")
            }
        }
        return armorView
    }

}