package com.arekor.gm_helper.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.arekor.gm_helper.data.model.GroupHasMonster

@Dao
interface GroupHasMonsterDao {
    @Query("SELECT * FROM group_has_monster")
    fun getAll(): LiveData<List<GroupHasMonster>>

    @Query("SELECT * FROM group_has_monster WHERE id = :id")
    fun getById(id : Long): LiveData<List<GroupHasMonster>>

    @Query("SELECT * FROM group_has_monster WHERE group_id = :id")
    fun getByGroup(id : Long): LiveData<List<GroupHasMonster>>

    @Query("SELECT * FROM group_has_monster WHERE monster_id = :id")
    fun getByMonster(id : Long): LiveData<List<GroupHasMonster>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(monster: GroupHasMonster)

    @Update
    fun update(monster: GroupHasMonster)

    @Delete
    fun delete(monster: GroupHasMonster)
}