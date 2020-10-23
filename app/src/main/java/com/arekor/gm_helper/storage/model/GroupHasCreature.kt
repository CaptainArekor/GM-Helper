package com.arekor.gm_helper.storage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "group_has_creature")
data class GroupHasCreature(
    @PrimaryKey
    var id: Long?,

    @ColumnInfo(name = "group_id")
    var group: Long?,

    @ColumnInfo(name = "creature_id")
    var creature: Long?
)