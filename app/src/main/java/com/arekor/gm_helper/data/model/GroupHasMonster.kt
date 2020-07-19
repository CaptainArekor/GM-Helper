package com.arekor.gm_helper.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "group_has_monster")
data class GroupHasMonster(
    @PrimaryKey
    var id: Long?,

    @ColumnInfo(name = "group_id")
    var group: Long?,

    @ColumnInfo(name = "monster_id")
    var monster: Long?
)