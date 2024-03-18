package fi.paradox.p6

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CoroutineViewModel : ViewModel() {
    private val _data = MutableStateFlow<String>("")
    val data: StateFlow<String> = _data

    fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = fetchData()
            _data.emit(result) // Aktualizácia Flow na hlavnom vlákne
        }
    }

    private suspend fun fetchData(): String {
        delay(2000) // Simulácia dlhotrvajúcej operácie
        return "Načítané dáta z ViewModelu"
    }
}
