package com.example.deogeobilchi.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log
import com.example.deogeobilchi.DeogeobilchiApplication
import com.example.deogeobilchi.model.EnumExamType
import com.google.gson.Gson

class PreferenceUtil(context: Context) {
    private val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    private val editor = prefs.edit()

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
        editor.putString(key, value)
        editor.apply()
    }

    fun setStringList(key: String, value: MutableList<EnumExamType>){
        val gson = Gson()
        editor.putString(key, gson.toJson(value))
        editor.apply()
    }

    fun getStringList(key:String): Array<EnumExamType>? {
        val gson = Gson()
        return gson.fromJson(prefs.getString(key, ""), Array<EnumExamType>::class.java)
    }

    fun getString(key: String): String? {
        return prefs.getString(key, "")
    }

    fun clear() {
        prefs.edit().clear().apply()
    }
}