package fi.paradox.p7

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private val viewModel: CoroutineViewModel by viewModels()
//    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val textViewData: TextView = findViewById(R.id.textViewData)
        val buttonLoadData: Button = findViewById(R.id.buttonLoadData)


        viewModel.loadData()
        // TODO 6
        lifecycleScope.launch(Dispatchers.IO) {
            viewModel.data.collectLatest {
                withContext(Dispatchers.Main){
                    textViewData.text = it
                }
            }
        }

        buttonLoadData.setOnClickListener {
            viewModel.loadData()

        }
    }
}
