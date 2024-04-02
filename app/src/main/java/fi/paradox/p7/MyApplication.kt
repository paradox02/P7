package fi.paradox.p7

import android.app.Application

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
       // DbSingleton.getDatabase(this)
    }
}