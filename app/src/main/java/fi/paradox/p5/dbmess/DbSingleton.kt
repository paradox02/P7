package fi.paradox.p5.dbmess

import android.content.Context
import androidx.room.Room
import fi.paradox.p5.AppDatabase

object DbSingleton {
    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "app_database"
            ).fallbackToDestructiveMigration()
             .build()
            INSTANCE = instance
            // Vrátiť inštanciu databázy
            instance
        }
    }
}