package com.arekor.gm_helper.storage.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.arekor.gm_helper.storage.model.Group

@Dao
interface GroupDao {
    @Query("SELECT * FROM combat_group")
    fun getAll(): LiveData<List<Group>>

    @Query("SELECT * FROM combat_group WHERE id = :id")
    fun getById(id : Long): LiveData<List<Group>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(group: Group)

    @Update
    fun update(group: Group)

    @Delete
    fun delete(group: Group)
}