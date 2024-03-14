package fi.paradox.p5.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import fi.paradox.p5.dbmodels.UserDto

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(userDto: UserDto)

    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<UserDto>
}
