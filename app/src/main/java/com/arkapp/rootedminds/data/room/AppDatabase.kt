package com.arkapp.rootedminds.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arkapp.rootedminds.data.models.TrackedActivity

/**
 * Created by Abdul Rehman on 16-05-2020.
 * Contact email - abdulrehman0796@gmail.com
 */


@Database(entities = [TrackedActivity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {


    abstract fun trackedActivityDao(): TrackedActivityDoa

    companion object {
        const val DATABASE_NAME = "MAIN_ROOTED_MINDS_DATABASE"

        fun getDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, DATABASE_NAME).build()
        }
    }
}