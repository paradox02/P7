package fi.paradox.p7.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fi.paradox.p7.dbmodels.PokemonDto

// TODO 2
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userDto: PokemonDto)

    @Query("SELECT * FROM pokemon")
    suspend fun getAllUsers(): List<PokemonDto>
}
