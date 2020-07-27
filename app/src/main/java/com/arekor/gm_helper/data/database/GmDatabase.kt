package com.arekor.gm_helper.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arekor.gm_helper.data.database.dao.GroupDao
import com.arekor.gm_helper.data.database.dao.GroupHasCreatureDao
import com.arekor.gm_helper.data.database.dao.CreatureDao
import com.arekor.gm_helper.data.model.Group
import com.arekor.gm_helper.data.model.GroupHasCreature
import com.arekor.gm_helper.data.model.Creature

const val DATABASE_VERSION = 1
const val DATABASE_NAME = "GMDatabase"

@Database(
    entities = [Creature::class, Group::class, GroupHasCreature::class],
    version = DATABASE_VERSION,
    exportSchema = true
)
abstract class GmDatabase : RoomDatabase() {
    abstract fun creatureDao(): CreatureDao
    abstract fun groupDao(): GroupDao
    abstract fun groupHasCreatureDao(): GroupHasCreatureDao

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