package com.arekor.gm_helper.dice

import android.app.Application
import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.arekor.gm_helper.R
import com.arekor.gm_helper.dice.model.Dice

const val DIVIDE_SIGN = 1
const val MULTIPLY_SIGN = 2
const val MINUS_SIGN = 3
const val PLUS_SIGN = 4

class DiceViewModel(application: Application) : AndroidViewModel(application) {
    lateinit var context: Context
    private var mediaPlayer: MediaPlayer? = null

    private var diceList = mutableListOf<Dice>()
    private var dices = MutableLiveData<MutableList<Dice>>()

    private var typingText = MutableLiveData<String>()
    private var resultText = MutableLiveData<String>()
    private var totalResultText = MutableLiveData<Int>()

    fun addDice(dice: Dice) {
        diceList.add(dice)
        dices.value = diceList
        generateTypingText()
    }

    fun modifyLast(dice: Dice) {
        val index = diceList.lastIndex
        if (index != -1)
            diceList.set(index, dice)
        generateTypingText()
    }

    fun popBackLast() {
        val index = diceList.lastIndex
        if (index != -1)
            diceList.removeAt(index)
        generateTypingText()
    }

    fun clearList(){
        diceList.clear()
        generateTypingText()
    }

    fun rollDices(){
        generateResult()
        playSound()
    }

    fun generateTypingText(){
        var typingTextTemp = ""
        for (x in 0 until diceList.size) {
            typingTextTemp += diceList[x].toString()
            if(x != diceList.size -1)
                typingTextTemp += " + "
        }
        typingText.value = typingTextTemp
    }

    fun getTotalResult() = totalResultText
    fun getResult() = resultText
    fun getTyping() = typingText

    private fun generateResult() {
        var total = 0
        var totalText = ""
        for (x in 0 until diceList.size) {
            val dice = diceList[x]
            dice.roll()
            when(dice.sign){
                PLUS_SIGN -> {
                    total += dice.getTotal()
                    if(x != 0)
                        totalText += " + "
                }
                MINUS_SIGN -> {
                    total -= dice.getTotal()
                    if(x != 0)
                        totalText += " - "
                }
                MULTIPLY_SIGN -> {
                    total *= dice.getTotal()
                    if(x != 0)
                        totalText += " x "
                }
                DIVIDE_SIGN -> {
                    total /= dice.getTotal()
                    if(x != 0)
                        totalText += " / "
                }
            }
            totalText += dice.getRollString()
        }
        resultText.value = totalText
        totalResultText.value = total
    }

    private fun playSound() {
        mediaPlayer = MediaPlayer.create(context, R.raw.dice)
        mediaPlayer?.setOnPreparedListener {
            it.start()
        }
    }
}