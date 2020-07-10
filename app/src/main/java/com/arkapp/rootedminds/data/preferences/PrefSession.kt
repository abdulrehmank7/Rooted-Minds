package com.arkapp.rootedminds.data.preferences

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson


class PrefSession(val context: Context) {

    private val pref: SharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    private val editor = pref.edit()
    private val gson = Gson()

    private fun String.put(long: Long) {
        editor.putLong(this, long)
        editor.commit()
    }

    private fun String.put(int: Int) {
        editor.putInt(this, int)
        editor.commit()
    }

    private fun String.put(string: String) {
        editor.putString(this, string)
        editor.commit()
    }

    private fun String.put(boolean: Boolean) {
        editor.putBoolean(this, boolean)
        editor.commit()
    }


    private fun String.getLong(): Long {
        return pref.getLong(this, 0)
    }

    private fun String.getInt(): Int {
        return pref.getInt(this, 0)
    }

    private fun String.getString(): String {
        return pref.getString(this, "")!!
    }

    private fun String.getBoolean(): Boolean {
        return pref.getBoolean(this, false)
    }

    /*********************************************/

    fun clearData() {
        editor.clear()
        editor.commit()
    }

    fun isAppOpened(isLoggedIn: Boolean) {
        PREF_APP_OPENED.put(isLoggedIn)
    }

    fun isAppOpened() = PREF_APP_OPENED.getBoolean()

    /*fun lastOpenedMonthEvent(generatedEvents: ArrayList<GeneratedEvents>) {
        PREF_LAST_OPENED_MONTH_EVENTS.put(gson.toJson(generatedEvents))
    }

    fun lastOpenedMonthEvent(): ArrayList<GeneratedEvents> {
        val type = object : TypeToken<ArrayList<GeneratedEvents?>?>() {}.type
        return gson.fromJson<ArrayList<GeneratedEvents>>(
            PREF_LAST_OPENED_MONTH_EVENTS.getString(),
            type) ?: ArrayList()
    }*/

}