package com.arekor.gm_helper.creature

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.arekor.gm_helper.data.database.GmDatabase
import com.arekor.gm_helper.data.model.Creature

class CreatureViewModel(application: Application) : AndroidViewModel(application) {
    val myApplication = application

    private var db : GmDatabase = GmDatabase.getInstance(myApplication)
    var allMonsters : LiveData<List<Creature>> = db.monsterDao().getAll()

    fun insert(creature: Creature){
        db.monsterDao().insert(creature)
    }

    fun deleteAll(){
        db.monsterDao().deleteAll()
    }

    fun delete(creature: Creature){
        db.monsterDao().delete(creature)
    }
}