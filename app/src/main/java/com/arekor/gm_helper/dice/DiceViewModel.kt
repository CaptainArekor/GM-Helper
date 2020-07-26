package com.arekor.gm_helper.dice

import android.app.Application
import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.arekor.gm_helper.R
import com.arekor.gm_helper.dice.model.CalculatorEntity
import com.arekor.gm_helper.dice.model.Dice

const val DIVIDE_SIGN = 1
const val MULTIPLY_SIGN = 2
const val MINUS_SIGN = 3
const val PLUS_SIGN = 4

class DiceViewModel(application: Application) : AndroidViewModel(application) {
    lateinit var context: Context
    private var mediaPlayer: MediaPlayer? = null

    private var entityList = mutableListOf<CalculatorEntity>()
    private var entities = MutableLiveData<MutableList<CalculatorEntity>>()

    private var typingText = MutableLiveData<String>()
    private var resultText = MutableLiveData<String>()
    private var totalResultText = MutableLiveData<Int>()

    private var activeEntity = MutableLiveData<CalculatorEntity>()

    fun addEntity(entity: CalculatorEntity) {
        entityList.add(entity)
        entities.value = entityList
        generateTypingText()
    }

    fun modifyLast(entity: CalculatorEntity) {
        val index = entityList.lastIndex
        if (index != -1)
            entityList[index] = entity
        generateTypingText()
    }

    fun popBackLast() {
        if (activeEntity.value == null) {
            val index = entityList.lastIndex
            if (index != -1)
                entityList.removeAt(index)
        } else {
            activeEntity.value = null
        }
        generateTypingText()
    }

    fun clearList() {
        entityList.clear()
        generateTypingText()
    }

    fun rollDices() {
        generateResult()
        playSound()
    }

    private fun generateTypingText() {
        var typingTextTemp = ""
        for (x in 0 until entityList.size) {
            typingTextTemp += entityList[x].toString()
            if (x != entityList.size - 1)
                typingTextTemp += " + "
        }
        if (activeEntity.value != null) {

        }
        typingText.value = typingTextTemp
    }

    fun getTotalResult() = totalResultText
    fun getResult() = resultText
    fun getTyping() = typingText

    private fun generateResult() {
        var total = 0
        var totalText = ""
        for (x in 0 until entityList.size) {
            val entity = entityList[x]
            entity.roll()
            when (entity.sign) {
                PLUS_SIGN -> {
                    total += entity.getTotal()
                    if (x != 0)
                        totalText += " + "
                }
                MINUS_SIGN -> {
                    total -= entity.getTotal()
                    if (x != 0)
                        totalText += " - "
                }
                MULTIPLY_SIGN -> {
                    total *= entity.getTotal()
                    if (x != 0)
                        totalText += " x "
                }
                DIVIDE_SIGN -> {
                    if (entity.getTotal() != 0) {
                        total /= entity.getTotal()
                        if (x != 0)
                            totalText += " / "
                    }

                }
            }
            totalText += entity.getRollString()
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

    fun addAmount(amount: Int) {
        if (activeEntity.value != null) {
            var amountText = activeEntity.value!!.amount.toString()
            amountText += amount.toString()
            activeEntity.value!!.amount = amountText.toInt()
        } else {
            activeEntity.value = CalculatorEntity(amount, PLUS_SIGN, null)
        }
    }

    fun addDice(diceValue: Int) {
        if (activeEntity.value != null) {
            if (activeEntity.value?.amount == -1)
                activeEntity.value?.amount = 1
            activeEntity.value?.dice = Dice(diceValue)
        } else {
            activeEntity.value = CalculatorEntity(1, PLUS_SIGN, Dice(diceValue))
        }
        addActiveEntity()
    }

    fun addSign(signValue: Int) {
        if (activeEntity.value != null)
            if (activeEntity.value!!.amount != -1)
                addActiveEntity()
            else
                activeEntity.value!!.sign = signValue
        else
            activeEntity.value = CalculatorEntity(-1, signValue, null)
    }

    private fun addActiveEntity() {
        addEntity(activeEntity.value!!)
        activeEntity.value = null
    }
}