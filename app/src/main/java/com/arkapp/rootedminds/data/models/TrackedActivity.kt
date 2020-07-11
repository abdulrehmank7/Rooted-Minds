package com.arkapp.rootedminds.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by Abdul Rehman on 10-07-2020.
 * Contact email - abdulrehman0796@gmail.com
 */
@Entity(tableName = "TRACKED_ACTIVITY")
data class TrackedActivity(
    @PrimaryKey(autoGenerate = true)
    val uid: Int?,

    @ColumnInfo(name = "title")
    val title: String?,

    @ColumnInfo(name = "date")
    val date: String?)