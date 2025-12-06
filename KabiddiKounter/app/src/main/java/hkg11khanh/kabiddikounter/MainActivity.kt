package hkg11khanh.kabiddikounter

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.color.utilities.Score
import com.google.android.material.color.utilities.Score.score
import hkg11khanh.kabiddikounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//    var score: Int = 0
    lateinit var binding: ActivityMainBinding
    val viewModel: ScoreViewModel by viewModels()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvInfo.text = viewModel.score.toString()

        binding.btAdd.setOnClickListener {
            viewModel.incrementScore()
            binding.tvInfo.text = viewModel.score.toString()
        }
    }
}