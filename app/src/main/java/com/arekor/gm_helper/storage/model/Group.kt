package com.arekor.gm_helper.storage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "combat_group")
data class Group(
    @PrimaryKey
    var id: Long?,

    @ColumnInfo(name = "name")
    var name: String
)