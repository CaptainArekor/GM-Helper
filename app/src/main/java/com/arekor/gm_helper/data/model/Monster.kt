package com.arekor.gm_helper.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "monster")
data class Monster(
    @PrimaryKey
    var id: Long?,

    @ColumnInfo(name = "name")
    var name: String
)