package fi.paradox.p5

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fi.paradox.p5.dbmodels.UserDto
import fi.paradox.p5.repository.UserRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: UserRepository) : ViewModel() {

    fun insertUser(user: UserDto) {
        viewModelScope.launch {
            repository.insertUser(user)
        }
    }

    fun getAllUsers() {
        viewModelScope.launch {
            val users = repository.getAllUsers()
            // Tu môžete aktualizovať UI s načítanými užívateľmi
        }
    }
}
