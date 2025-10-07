package hkg11khanh.lemonade

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
//    var lemonStates: Array<String> = arrayOf("tree", "lemon", "drink", "again")
    var lemonState: Int = 0
    var tapsLeftWhenSqueeze: Int = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val appImage: ImageView = findViewById(R.id.imageView)
        appImage.setOnClickListener {
            setToNextState()
        }
        appImage.setImageResource(R.drawable.lemon_tree)

        val textView: TextView = findViewById(R.id.textView)
        textView.text = getString(R.string.click_to_select_a_lemon)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setToNextState() {
        if (lemonState % 4 == 0) {
            tapsLeftWhenSqueeze = (3..10).random()
        }
        if (lemonState % 4 == 1) {
            tapsLeftWhenSqueeze -= 1
            val toastText: String = "${getString(R.string.tap)} $tapsLeftWhenSqueeze ${getString(R.string.more_times_to_squeeze)}"
            val toast = Toast.makeText(this, toastText, Toast.LENGTH_SHORT)
            toast.show()
            if (tapsLeftWhenSqueeze > 0) {
                return
            }
        }
        lemonState++
        val state: Int = lemonState % 4
        val appImage: ImageView = findViewById(R.id.imageView)
        when (state) {
            0 -> {
                appImage.setImageResource(R.drawable.lemon_tree)
                val textView: TextView = findViewById(R.id.textView)
                textView.text = getString(R.string.click_to_select_a_lemon)
            }
            1 -> {
                appImage.setImageResource(R.drawable.lemon_squeeze)
                val textView: TextView = findViewById(R.id.textView)
                textView.text = getString(R.string.click_to_juice_the_lemon)
            }
            2 -> {
                appImage.setImageResource(R.drawable.lemon_drink)
                val textView: TextView = findViewById(R.id.textView)
                textView.text = getString(R.string.click_to_drink_your_lemonade)
            }
            3 -> {
                appImage.setImageResource(R.drawable.lemon_restart)
                val textView: TextView = findViewById(R.id.textView)
                textView.text = getString(R.string.click_to_start_again)
            }
        }
    }
}