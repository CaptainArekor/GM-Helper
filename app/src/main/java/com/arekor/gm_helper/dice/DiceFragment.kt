package com.arekor.gm_helper.dice

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.arekor.gm_helper.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_dice.view.*
import kotlin.random.Random
import kotlin.random.nextInt

class DiceFragment : BottomSheetDialogFragment() {
    private lateinit var diceView : View
    private lateinit var resultView : TextView

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        diceView = inflater.inflate(R.layout.fragment_dice, container, false)
        resultView = diceView.dice_result_text
        diceView.dice_d4_button.setOnClickListener{showSimpleResult(4)}
        diceView.dice_d6_button.setOnClickListener{showSimpleResult(6)}
        diceView.dice_d8_button.setOnClickListener{showSimpleResult(8)}
        diceView.dice_d10_button.setOnClickListener{showSimpleResult(10)}
        diceView.dice_d12_button.setOnClickListener{showSimpleResult(12)}
        diceView.dice_d20_button.setOnClickListener{showSimpleResult(20)}
        diceView.dice_d100_button.setOnClickListener{showSimpleResult(100)}
        return diceView
    }

    private fun showSimpleResult(value: Int){
        val resultValue = roll(value)
        resultView.text = resultValue.toString()
        playSound()
    }

    private fun roll(value: Int) : Int{
        val range = IntRange(1, value)
        return Random.nextInt(range)
    }

    private fun playSound(){
        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.dice)
        mediaPlayer?.setOnPreparedListener{
            it.start()
        }
    }
}