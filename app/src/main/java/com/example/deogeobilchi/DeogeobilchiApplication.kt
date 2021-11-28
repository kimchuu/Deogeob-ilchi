package com.example.deogeobilchi

import android.app.Application
import com.example.deogeobilchi.di.roomModule
import com.example.deogeobilchi.di.viewModelModule
import com.example.deogeobilchi.util.PreferenceUtil
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class DeogeobilchiApplication : Application() {

    companion object {
        lateinit var prefs: PreferenceUtil
    }

    override fun onCreate() {
        super.onCreate()

        prefs = PreferenceUtil(applicationContext)
        startKoin {
            androidLogger()
            androidContext(this@DeogeobilchiApplication)
            modules(listOf(viewModelModule, roomModule))
        }
    }
}