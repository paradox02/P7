package fi.paradox.p6

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel: CoroutineViewModel by viewModels()
//    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val textViewData: TextView = findViewById(R.id.textViewData)
        val buttonLoadData: Button = findViewById(R.id.buttonLoadData)


        // TODO 6
        lifecycleScope.launch(Dispatchers.IO) {
            viewModel.data.map {
                "$it asdasdas"
            }.collectLatest {
                textViewData.text = it
            }
        }

        buttonLoadData.setOnClickListener {
            viewModel.loadData()

        }
    }
}
