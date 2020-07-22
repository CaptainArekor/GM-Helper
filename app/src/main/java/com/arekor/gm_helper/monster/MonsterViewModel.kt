package com.arekor.gm_helper.monster

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.arekor.gm_helper.data.database.GmDatabase
import com.arekor.gm_helper.data.model.Monster

class MonsterViewModel(application: Application) : AndroidViewModel(application) {
    val myApplication = application

    private var db : GmDatabase = GmDatabase.getInstance(myApplication)
    var allMonsters : LiveData<List<Monster>> = db.monsterDao().getAll()

    fun insert(monster: Monster){
        db.monsterDao().insert(monster)
    }

    fun deleteAll(){
        db.monsterDao().deleteAll()
    }
}