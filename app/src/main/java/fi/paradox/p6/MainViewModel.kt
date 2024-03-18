package fi.paradox.p6

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fi.paradox.p6.dbmodels.UserDto
import fi.paradox.p6.repository.UserRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: UserRepository) : ViewModel() {

    init {
        insertUser(UserDto(0, "stevo", 5))
    }

    fun insertUser(user: UserDto) {
        viewModelScope.launch {
            repository.insertUser(user)
        }
    }

    fun loadData() {
        viewModelScope.launch {
            val users = repository.getAllUsers()
            Log.i("USERS", users.joinToString(","))
            // Tu môžete aktualizovať UI s načítanými užívateľmi
        }
    }
}
