package com.arkapp.rootedminds.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by Abdul Rehman on 10-07-2020.
 * Contact email - abdulrehman0796@gmail.com
 */
@Entity(tableName = "REFLECTION")
data class Reflection(
    @PrimaryKey(autoGenerate = true)
    val uid: Int?,

    @ColumnInfo(name = "title")
    val title: String?,

    @ColumnInfo(name = "location")
    val location: String?,

    @ColumnInfo(name = "note1")
    val note1: String?,

    @ColumnInfo(name = "note2")
    val note2: String?,

    @ColumnInfo(name = "note3")
    val note3: String?,

    @ColumnInfo(name = "note4")
    val note4: String?,

    @ColumnInfo(name = "note5")
    val note5: String?,

    @ColumnInfo(name = "note6")
    val note6: String?,

    @ColumnInfo(name = "date")
    val date: String?)