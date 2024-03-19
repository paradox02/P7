package fi.paradox.p6

import androidx.room.Database
import androidx.room.RoomDatabase
import fi.paradox.p6.dao.UserDao
import fi.paradox.p6.dbmodels.UserDto

@Database(entities = [UserDto::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
//    TODO 3
    abstract fun userDao(): UserDao
}
