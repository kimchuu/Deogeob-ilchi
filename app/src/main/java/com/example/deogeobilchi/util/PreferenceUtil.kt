package com.example.deogeobilchi.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class PreferenceUtil(context: Context) {
    private val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun getInt(key: String, int: Int): Int {
        return prefs.getInt(key, int)
    }

    fun setInt(key: String, int: Int) {
        prefs.edit().putInt(key, int).commit()
    }

    fun setIntList(key: String, values: MutableList<Int>) {
        var i = 1
        if (values.isNotEmpty()) {
            values.forEach {
                prefs.edit().putInt(key + i, it)
                i++
            }
        }
    }

    fun setString(key: String, value: String){
        prefs.edit().putString(key, value)
    }

    fun getString(key: String){
        prefs.getString(key, "")
    }

    fun clear() {
        prefs.edit().clear().apply()
    }
}