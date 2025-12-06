package hkg11khanh.kabiddikounter

import androidx.lifecycle.ViewModel
import com.google.android.material.color.utilities.Score.score

class ScoreViewModel: ViewModel() {
    var score: Int = 0

    fun incrementScore() {
        score++
    }
}