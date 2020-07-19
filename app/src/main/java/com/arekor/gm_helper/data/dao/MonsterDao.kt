package com.arekor.gm_helper.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.arekor.gm_helper.data.model.Monster

@Dao
interface MonsterDao {
    @Query("SELECT * FROM monster")
    fun getAll(): LiveData<List<Monster>>

    @Query("SELECT * FROM monster WHERE id = :id")
    fun getById(id : Long): LiveData<List<Monster>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(monster: Monster)

    @Update
    fun update(monster: Monster)

    @Delete
    fun delete(monster: Monster)
}