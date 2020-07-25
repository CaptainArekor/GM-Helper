package com.arekor.gm_helper.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.arekor.gm_helper.data.model.GroupHasCreature

@Dao
interface GroupHasCreatureDao {
    @Query("SELECT * FROM group_has_creature")
    fun getAll(): LiveData<List<GroupHasCreature>>

    @Query("SELECT * FROM group_has_creature WHERE id = :id")
    fun getById(id : Long): LiveData<List<GroupHasCreature>>

    @Query("SELECT * FROM group_has_creature WHERE group_id = :id")
    fun getByGroup(id : Long): LiveData<List<GroupHasCreature>>

    @Query("SELECT * FROM group_has_creature WHERE creature_id = :id")
    fun getByCreature(id : Long): LiveData<List<GroupHasCreature>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(creature: GroupHasCreature)

    @Update
    fun update(creature: GroupHasCreature)

    @Delete
    fun delete(creature: GroupHasCreature)
}