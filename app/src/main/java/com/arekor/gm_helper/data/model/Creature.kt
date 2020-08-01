package com.arekor.gm_helper.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "creature")
data class Creature(
    @PrimaryKey
    var id: Long?,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "challenge_rating")
    var challenge_rating: Double,

    @ColumnInfo(name = "image", typeAffinity = ColumnInfo.BLOB)
    var image: ByteArray? = null,

    @ColumnInfo(name = "size")
    var size: String,

    @ColumnInfo(name = "type")
    var type: String,

    @ColumnInfo(name = "alignment")
    var alignment: String,

    @ColumnInfo(name = "attribute_strength", defaultValue = "10")
    var strength: Int,

    @ColumnInfo(name = "attribute_dexterity", defaultValue = "10")
    var dexterity: Int,

    @ColumnInfo(name = "attribute_constitution", defaultValue = "10")
    var constitution: Int,

    @ColumnInfo(name = "attribute_intelligence", defaultValue = "10")
    var intelligence: Int,

    @ColumnInfo(name = "attribute_wisdom", defaultValue = "10")
    var wisdom: Int,

    @ColumnInfo(name = "attribute_charisma", defaultValue = "10")
    var charisma: Int,

    @ColumnInfo(name = "attribute_defense", defaultValue = "0")
    var defense: Int,

    @ColumnInfo(name = "attribute_initiative", defaultValue = "10")
    var initiative: Int,

    @ColumnInfo(name = "health_points", defaultValue = "1")
    var health_points: Int,

    @ColumnInfo(name = "race")
    var race: String,

    @ColumnInfo(name = "description")
    var description: String
) {
}