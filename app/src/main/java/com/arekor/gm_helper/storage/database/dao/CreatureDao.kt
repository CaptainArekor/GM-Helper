package com.arekor.gm_helper.storage.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.arekor.gm_helper.storage.model.Creature

@Dao
interface CreatureDao {
    @Query("SELECT * FROM creature")
    fun getAll(): LiveData<List<Creature>>

    @Query("SELECT * FROM creature WHERE id = :id")
    fun getById(id : Long): LiveData<List<Creature>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(creature: Creature)

    @Update
    fun update(creature: Creature)

    @Delete
    fun delete(creature: Creature)

    @Query("DELETE FROM creature")
    fun deleteAll()
}