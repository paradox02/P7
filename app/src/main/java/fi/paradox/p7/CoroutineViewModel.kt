package fi.paradox.p7

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fi.paradox.p7.client.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CoroutineViewModel : ViewModel() {
    private val _data = MutableStateFlow<String>("")
    val data: StateFlow<String> = _data

    val client = RetrofitClient()

    fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = fetchData()
            _data.emit(result) // Aktualizácia Flow na hlavnom vlákne
        }
    }

    private suspend fun fetchData(): String {
        val pokemon = client.fetchPokemonData("ditto")
        return pokemon.toString()
    }
}
