package fi.paradox.p5.repository

import fi.paradox.p5.dao.UserDao
import fi.paradox.p5.dbmodels.UserDto

class UserRepository(private val userDao: UserDao) {
    suspend fun insertUser(userDto: UserDto) {
        userDao.insertUser(userDto)
    }

    suspend fun getAllUsers(): List<UserDto> {
        return userDao.getAllUsers()
    }
}
