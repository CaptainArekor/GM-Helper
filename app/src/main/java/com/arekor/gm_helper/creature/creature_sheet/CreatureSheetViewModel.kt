package com.arekor.gm_helper.creature.creature_sheet

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.arekor.gm_helper.data.database.GmDatabase
import com.arekor.gm_helper.data.model.Creature
import com.arekor.gm_helper.utils.CreatureManager
import org.jetbrains.anko.doAsync

class CreatureSheetViewModel(application: Application) : AndroidViewModel(application) {
    private val myApplication = application

    private var db : GmDatabase = GmDatabase.getInstance(myApplication)
    var currentCreature : MutableLiveData<Creature> = MutableLiveData(CreatureManager.createNewCreature())


    fun insert(){
        doAsync {
            db.creatureDao().insert(currentCreature.value!!)
        }
    }

    fun get(id: Long){
        val creatureList = db.creatureDao().getById(id).value
        if (creatureList != null) {
            currentCreature.value = creatureList[0]
        }
    }

    fun modify(){
        db.creatureDao().update(currentCreature.value!!)
    }

    fun delete(){
        db.creatureDao().delete(currentCreature.value!!)
    }

    fun checkMandatory() : Boolean{
        return (currentCreature.value!!.name.isNotEmpty())
    }











    fun setName(name: String){
        currentCreature.value!!.name = name
    }

    fun getName(): String{
        return currentCreature.value!!.name
    }

    fun setComment(comment: String){
        currentCreature.value!!.description = comment
    }

    fun getComment(): String{
        return currentCreature.value!!.description
    }
}