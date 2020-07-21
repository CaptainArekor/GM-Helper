package com.arekor.gm_helper.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arekor.gm_helper.data.dao.GroupDao
import com.arekor.gm_helper.data.dao.GroupHasMonsterDao
import com.arekor.gm_helper.data.dao.MonsterDao
import com.arekor.gm_helper.data.model.Group
import com.arekor.gm_helper.data.model.GroupHasMonster
import com.arekor.gm_helper.data.model.Monster

const val DATABASE_VERSION = 1
const val DATABASE_NAME = "GMDatabase"

@Database(
    entities = [Monster::class, Group::class, GroupHasMonster::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class GmDatabase : RoomDatabase() {
    abstract fun monsterDao(): MonsterDao
    abstract fun groupDao(): GroupDao
    abstract fun groupHasMonsterDao(): GroupHasMonsterDao

    companion object {
        private var INSTANCE: GmDatabase? = null

        fun getInstance(context: Context): GmDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    GmDatabase::class.java,
                    DATABASE_NAME
                )
                    .build()
            }
            return INSTANCE as GmDatabase
        }
    }
}