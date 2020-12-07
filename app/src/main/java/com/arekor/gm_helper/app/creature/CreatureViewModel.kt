package com.arekor.gm_helper.app.creature

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.arekor.gm_helper.storage.database.GmDatabase
import com.arekor.gm_helper.storage.model.Creature
import org.jetbrains.anko.doAsync

class CreatureViewModel(application: Application) : AndroidViewModel(application) {
    private val myApplication = application

    private var db : GmDatabase = GmDatabase.getInstance(myApplication)
    var allMonsters : LiveData<List<Creature>> = db.creatureDao().getAll()

    fun insert(creature: Creature){
        doAsync {
            db.creatureDao().insert(creature)
        }
    }

    fun deleteAll(){
        db.creatureDao().deleteAll()
    }

    fun delete(creature: Creature){
        db.creatureDao().delete(creature)
    }

    fun sheetIsValid() : Boolean {
        return true
    }
}