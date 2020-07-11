package com.arkapp.rootedminds.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arkapp.rootedminds.data.models.TrackedActivity

/**
 * Created by Abdul Rehman on 16-05-2020.
 * Contact email - abdulrehman0796@gmail.com
 */

@Dao
interface TrackedActivityDoa {

    @Query("SELECT * FROM TRACKED_ACTIVITY")
    suspend fun getAllTrackedActivities(): List<TrackedActivity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vararg activity: TrackedActivity)

    @Query("DELETE FROM TRACKED_ACTIVITY")
    suspend fun deleteAll()
}