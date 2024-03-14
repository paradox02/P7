package fi.paradox.p5

import androidx.room.Database
import androidx.room.RoomDatabase
import fi.paradox.p5.dao.UserDao
import fi.paradox.p5.dbmodels.UserDto

@Database(entities = [UserDto::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
