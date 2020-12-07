package com.arekor.gm_helper.app.dice.dice.model

import kotlin.random.Random
import kotlin.random.nextInt

data class Dice(var value: Int, var custom: Boolean) {
    var result : Int = 0

    fun roll(){
        result = if(value > 0)
            singleRoll(value)
        else
            0
    }

    private fun singleRoll(value: Int): Int {
        val range = IntRange(1, value)
        return Random.nextInt(range)
    }
}