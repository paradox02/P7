package fi.paradox.p6.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fi.paradox.p6.dbmodels.UserDto

// TODO 2
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userDto: UserDto)

    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<UserDto>
}
