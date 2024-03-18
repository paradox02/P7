package fi.paradox.p6.repository

import fi.paradox.p6.AppDatabase
import fi.paradox.p6.dbmodels.UserDto

// TODO 5
class UserRepository(private val db: AppDatabase) {
    suspend fun insertUser(userDto: UserDto) {
//        db.userDao().insertUser(userDto)
    }

    suspend fun getAllUsers(): List<UserDto> {
//        return db.userDao().getAllUsers()
    }
}
