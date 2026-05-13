package com.example.audiorouter

import android.app.Application
import android.content.Context

class App : Application() {
    companion object {
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
        ShizukuHelper.initialize()
    }

    override fun onTerminate() {
        super.onTerminate()
        ShizukuHelper.cleanup()
    }
}
