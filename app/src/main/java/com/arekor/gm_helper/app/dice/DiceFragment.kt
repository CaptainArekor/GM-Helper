package com.arekor.gm_helper.app.dice.dice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.arekor.gm_helper.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_dice.*
import kotlinx.android.synthetic.main.fragment_dice.view.*

class DiceFragment : BottomSheetDialogFragment() {
    private lateinit var diceView : View
    private lateinit var resultView : TextView
    lateinit var model : DiceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProviders.of(this).get(DiceViewModel::class.java)
        model.context = requireContext()

        val totalResult: MutableLiveData<Int> = model.getTotalResult()
        totalResult.observe(this, Observer {
            val resultDice = "= " + totalResult.value.toString()
            dice_result_value.text = resultDice
        })
        val totalTextResult: MutableLiveData<String> = model.getResult()
        totalTextResult.observe(this, Observer {
            dice_result_text.text = totalTextResult.value
        })
        val totalTypingText: MutableLiveData<String> = model.getTyping()
        totalTypingText.observe(this, Observer {
            dice_choice_text.text = totalTypingText.value
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        diceView = inflater.inflate(R.layout.fragment_dice, container, false)
        resultView = diceView.dice_result_text
        diceView.dice_d2_button.setOnClickListener{onDice(2)}
        diceView.dice_d4_button.setOnClickListener{onDice(4)}
        diceView.dice_d6_button.setOnClickListener{onDice(6)}
        diceView.dice_d8_button.setOnClickListener{onDice(8)}
        diceView.dice_d10_button.setOnClickListener{onDice(10)}
        diceView.dice_d12_button.setOnClickListener{onDice(12)}
        diceView.dice_d20_button.setOnClickListener{onDice(20)}
        diceView.dice_d100_button.setOnClickListener{onDice(100)}
        diceView.dice_dx_button.setOnClickListener{onDice(-1)}

        diceView.dice_1_button.setOnClickListener{onDigit(1)}
        diceView.dice_2_button.setOnClickListener{onDigit(2)}
        diceView.dice_3_button.setOnClickListener{onDigit(3)}
        diceView.dice_4_button.setOnClickListener{onDigit(4)}
        diceView.dice_5_button.setOnClickListener{onDigit(5)}
        diceView.dice_6_button.setOnClickListener{onDigit(6)}
        diceView.dice_7_button.setOnClickListener{onDigit(7)}
        diceView.dice_8_button.setOnClickListener{onDigit(8)}
        diceView.dice_9_button.setOnClickListener{onDigit(9)}
        diceView.dice_0_button.setOnClickListener{onDigit(0)}

        diceView.dice_clear.setOnClickListener{model.popBackLast()}
        diceView.dice_multiply.setOnClickListener{onSign(MULTIPLY_SIGN)}
        diceView.dice_divide.setOnClickListener{onSign(DIVIDE_SIGN)}
        diceView.dice_plus.setOnClickListener{onSign(PLUS_SIGN)}
        diceView.dice_minus.setOnClickListener{onSign(MINUS_SIGN)}
        diceView.dice_roll_button.setOnClickListener{model.rollDices()}
        return diceView
    }

    private fun onDigit(value: Int){
        model.addAmount(value)
    }

    private fun onSign(sign: Int){
        model.addSign(sign)
    }

    private fun onDice(diceValue: Int){
        model.addDice(diceValue)
    }
}