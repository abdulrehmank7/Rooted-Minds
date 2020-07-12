package com.arkapp.rootedminds.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arkapp.rootedminds.data.models.Reflection

/**
 * Created by Abdul Rehman on 16-05-2020.
 * Contact email - abdulrehman0796@gmail.com
 */

@Dao
interface ReflectionDoa {

    @Query("SELECT * FROM REFLECTION")
    suspend fun getAllReflection(): List<Reflection>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vararg activity: Reflection)

    @Query("DELETE FROM TRACKED_ACTIVITY")
    suspend fun deleteAll()
}