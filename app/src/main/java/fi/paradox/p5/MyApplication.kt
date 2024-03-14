package fi.paradox.p5

import android.app.Application
import fi.paradox.p5.dbmess.DbSingleton

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DbSingleton.getDatabase(this)
    }
}