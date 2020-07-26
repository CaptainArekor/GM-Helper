package com.arekor.gm_helper.dice.model

data class CalculatorEntity(var amount: Int, var sign: Int, var dice: Dice?) {
    var results = mutableListOf<Int>()

    override fun toString(): String {
        return if(dice != null)
            amount.toString() + "d" + dice!!.value.toString()
        else if( amount == -1)
            "d" + dice!!.value.toString()
        else amount.toString()
    }

    fun roll(){
        results.clear()
        for (x in 1..amount) {
            if(dice != null){
                dice!!.roll()
                results.add(dice!!.result)
            }
        }
    }

    fun getTotal() : Int{
        if (results.size == 0){
            return 0
        } else if (dice == null){
            return amount
        } else {
            var total = 0
            results.forEach{
                total += it
            }
            return total
        }
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