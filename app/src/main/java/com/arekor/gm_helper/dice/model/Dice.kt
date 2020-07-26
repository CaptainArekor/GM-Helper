package com.arekor.gm_helper.dice.model

import kotlin.random.Random
import kotlin.random.nextInt

data class Dice(var value: Int, var amount: Int, var sign: Int) {
    var results = mutableListOf<Int>()

    init {
        refreshResult()
    }

    override fun toString(): String {
        return amount.toString() + "d" + value.toString()
    }

    private fun refreshResult() {
        results.clear()
        for (x in 1..amount) {
            results.add(singleRoll(value))
        }
    }

    fun roll(){
        refreshResult()
    }

    fun getTotal(): Int {
        return if (results.size == 0)
            0
        else {
            var total = 0
            results.forEach {
                total += it
            }
            total
        }
    }

    private fun singleRoll(value: Int): Int {
        val range = IntRange(1, value)
        return Random.nextInt(range)
    }

    fun getRollString(): String {
        var resultText : String = "("
        for(x in 0 until results.size){
            resultText += results[x]
            if(x != results.size-1){
                resultText += " + "
            }
        }
        resultText += ")"
        return resultText
    }
}