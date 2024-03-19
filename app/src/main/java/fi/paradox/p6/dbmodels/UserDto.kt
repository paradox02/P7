package fi.paradox.p6.dbmodels

import androidx.room.Entity
import androidx.room.PrimaryKey

// TODO 1
@Entity(tableName = "users")
data class UserDto(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val age: Int
)
