package com.arkapp.rootedminds.utility

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen

class RootedMindsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }

}