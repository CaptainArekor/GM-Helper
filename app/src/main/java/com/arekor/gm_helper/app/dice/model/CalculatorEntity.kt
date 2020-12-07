package com.arekor.gm_helper.app.dice.dice.model

data class CalculatorEntity(var amount: Int, var sign: Int, var dice: Dice?) {
    private var results = mutableListOf<Int>()

    override fun toString(): String {
        return if (dice != null) {
            if (amount == 1) {
                "d" + getSafeValue()
            } else {
                getSafeAmount().toString() + "d" + getSafeValue()
            }
        } else {
            getSafeAmount().toString()
        }
    }

    private fun getSafeValue(): String {
        if (dice!!.value == -1)
            return ""
        return (dice!!.value).toString()
    }

    private fun getSafeAmount(): Int {
        if (amount == -1)
            return 0
        return amount
    }

    fun roll() {
        results.clear()
        if (dice == null) {
            results.add(getSafeAmount())
        } else
            for (x in 1..amount) {
                if (dice != null) {
                    dice!!.roll()
                    results.add(dice!!.result)
                }
            }
    }

    fun getTotal(): Int {
        return if (results.size == 0) {
            0
        } else if (dice == null) {
            getSafeAmount()
        } else {
            var total = 0
            results.forEach {
                total += it
            }
            total
        }
    }

    fun getRollString(): String {
        var resultText = "("
        for (x in 0 until results.size) {
            resultText += results[x]
            if (x != results.size - 1) {
                resultText += " + "
            }
        }
        resultText += ")"
        return resultText
    }
}