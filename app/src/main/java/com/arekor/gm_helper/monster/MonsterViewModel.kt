package com.arekor.gm_helper.monster

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.arekor.gm_helper.data.database.GmDatabase
import com.arekor.gm_helper.data.model.Monster

class MonsterViewModel(application: Application): AndroidViewModel(application) {
    private val db:GmDatabase = GmDatabase.getInstance(application)
    internal val allMonsters : LiveData<List<Monster>> = db.monsterDao().getAll()

    fun insert(monster: Monster){
        db.monsterDao().insert(monster)
    }
}