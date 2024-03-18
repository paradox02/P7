package fi.paradox.p6

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import fi.paradox.p6.R

class MainActivity : AppCompatActivity() {

//    private val viewModel: MainViewModel by viewModels()
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        viewModel = ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java)

        val textViewData: TextView = findViewById(R.id.textViewData)
        val buttonLoadData: Button = findViewById(R.id.buttonLoadData)


//        lifecycleScope.launch {
//            viewModel.data.collectLatest {
//                textViewData.text= it
//            }
//        }

        buttonLoadData.setOnClickListener {
            viewModel.loadData()

        }
    }
}
