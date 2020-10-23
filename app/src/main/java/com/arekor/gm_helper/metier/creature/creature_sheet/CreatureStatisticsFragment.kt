package com.arekor.gm_helper.metier.creature.creature_sheet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.arekor.gm_helper.R
import kotlinx.android.synthetic.main.fragment_creature_statistics.view.*

class CreatureStatisticsFragment : Fragment() {
    private val emptyValue = "0"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val statsView = inflater.inflate(R.layout.fragment_creature_statistics, container, false)

        statsView.creature_statistics_strength.setOnFocusChangeListener{ view: View, _: Boolean ->
            checkEmptyValue(view as EditText)
        }
        statsView.creature_statistics_dexterity.setOnFocusChangeListener{ view: View, _: Boolean ->
            checkEmptyValue(view as EditText)
        }
        statsView.creature_statistics_constitution.setOnFocusChangeListener{ view: View, _: Boolean ->
            checkEmptyValue(view as EditText)
        }
        statsView.creature_statistics_intelligence.setOnFocusChangeListener{ view: View, _: Boolean ->
            checkEmptyValue(view as EditText)
        }
        statsView.creature_statistics_wisdom.setOnFocusChangeListener{ view: View, _: Boolean ->
            checkEmptyValue(view as EditText)
        }
        statsView.creature_statistics_charisma.setOnFocusChangeListener{ view: View, _: Boolean ->
            checkEmptyValue(view as EditText)
        }

        return statsView
    }

    private fun checkEmptyValue(EditText: EditText){
        if (EditText.text != null) {
            if(EditText.text.isEmpty())
                EditText.setText(emptyValue)
        }
    }

}