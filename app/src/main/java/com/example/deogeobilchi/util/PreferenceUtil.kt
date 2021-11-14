package com.example.deogeobilchi.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class PreferenceUtil(context : Context) {
    private val prefs : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    private var editor : SharedPreferences.Editor = prefs.edit()


}