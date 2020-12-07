package com.arekor.gm_helper.app.dice.dice

import android.app.Application
import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.arekor.gm_helper.R
import com.arekor.gm_helper.app.dice.dice.model.CalculatorEntity
import com.arekor.gm_helper.app.dice.dice.model.Dice

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

    private fun addEntity(entity: CalculatorEntity) {
        entityList.add(entity)
        activeEntity.value = null
        entities.value = entityList
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

    fun rollDices() {
        addActiveEntity()
        generateResult()
        playSound()
    }

    private fun generateTypingText() {
        var typingTextTemp = ""
        for (x in 0 until entityList.size) {
            if (entityList[x].sign == MINUS_SIGN || x != 0)
                typingTextTemp += getSign(entityList[x].sign)
            typingTextTemp += entityList[x].toString()
        }
        if (activeEntity.value != null) {
            val position = entityList.size
            typingTextTemp += getActiveEntityString(position)
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
                PLUS_SIGN -> total += entity.getTotal()
                MINUS_SIGN -> total -= entity.getTotal()
                MULTIPLY_SIGN -> total *= entity.getTotal()
                DIVIDE_SIGN ->
                    if (entity.getTotal() != 0) {
                        total /= entity.getTotal()
                    }
            }
            if (x != 0)
                totalText += getSign(entity.sign)
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
        val safeAmount: Int = if (amount > 100)
            100
        else amount
        if (activeEntity.value != null) {
            if(activeEntity.value!!.dice != null && activeEntity.value!!.dice?.custom!!){
                //
                var amountText = activeEntity.value!!.dice?.value.toString()
                if (amountText != "-1")
                    amountText += safeAmount.toString()
                else
                    amountText = safeAmount.toString()
                activeEntity.value!!.dice?.value = amountText.toInt()
                //
            } else {
                var amountText = activeEntity.value!!.amount.toString()
                if (amountText != "-1")
                    amountText += safeAmount.toString()
                else
                    amountText = safeAmount.toString()
                activeEntity.value!!.amount = amountText.toInt()
            }
        } else {
            activeEntity.value = CalculatorEntity(safeAmount, PLUS_SIGN, null)
        }
        generateTypingText()
    }

    fun addDice(diceValue: Int) {
        if (activeEntity.value != null) {
            if (activeEntity.value?.amount == -1)
                activeEntity.value?.amount = 1
            activeEntity.value?.dice = createDice(diceValue)
        } else {
            activeEntity.value = CalculatorEntity(1, PLUS_SIGN, createDice(diceValue))
        }
        if(!activeEntity.value!!.dice?.custom!!)
            addActiveEntity()
        generateTypingText()
    }

    private fun createDice(diceValue: Int): Dice {
        return if(diceValue == -1)
            Dice(diceValue, true)
        else
            Dice(diceValue, false)
    }

    fun addSign(signValue: Int) {
        if (activeEntity.value != null)
            if (activeEntity.value!!.amount != -1)
                addActiveEntity()
            else
                activeEntity.value!!.sign = signValue
        activeEntity.value = CalculatorEntity(-1, signValue, null)
        generateTypingText()
    }

    private fun addActiveEntity() {
        if (verifyActiveEntity()) {
            addEntity(activeEntity.value!!)
        }
        activeEntity.value = null
    }

    private fun verifyActiveEntity(): Boolean {
        if (activeEntity.value != null) {
            if (activeEntity.value!!.amount == -1 && activeEntity.value!!.dice != null)
                return false
            return true
        }
        return false
    }

    private fun getSign(sign: Int): String {
        return when (sign) {
            MULTIPLY_SIGN -> " x "
            DIVIDE_SIGN -> " / "
            PLUS_SIGN -> " + "
            MINUS_SIGN -> " - "
            else -> ""
        }
    }

    private fun getActiveEntityString(position: Int): String {
        val currentEntity = activeEntity.value
        if (currentEntity != null) {
            if (currentEntity.amount == -1) {
                if (currentEntity.dice == null) {
                    return getSign(currentEntity.sign)
                }
            }
        }
        if (position != 0) {
            if (currentEntity != null) {
                return getSign(currentEntity.sign) + activeEntity.value.toString()
            }
        }
        return activeEntity.value.toString()
    }
}