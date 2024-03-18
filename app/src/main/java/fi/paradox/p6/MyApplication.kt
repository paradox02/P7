package fi.paradox.p6

import android.app.Application
import fi.paradox.p6.dbmess.DbSingleton

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DbSingleton.getDatabase(this)
    }
}