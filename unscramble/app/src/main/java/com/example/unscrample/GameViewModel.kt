package com.example.unscrample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.unscramble.MAX_NO_OF_WORDS
import com.example.unscramble.SCORE_INCREASE
import com.example.unscramble.allWordsList

class GameViewModel : ViewModel() {

    // LiveData for score
    private val _score = MutableLiveData(0)
    val score: LiveData<Int>
        get() = _score

    // LiveData for word count
    private val _currentWordCount = MutableLiveData(0)
    val currentWordCount: LiveData<Int>
        get() = _currentWordCount

    // LiveData for scrambled word
    private val _currentScrambledWord = MutableLiveData<String>()
    val currentScrambledWord: LiveData<String>
        get() = _currentScrambledWord

    private var wordsList = mutableListOf<String>()
    private lateinit var currentWord: String

    private fun getNextWord() {
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()

        while (String(tempWord).equals(currentWord, false)) {
            tempWord.shuffle()
        }

        if (wordsList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambledWord.value = String(tempWord)
            _currentWordCount.value = _currentWordCount.value?.inc()
            wordsList.add(currentWord)
        }
    }

    fun nextWord(): Boolean {
        return if (_currentWordCount.value!! < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }

    private fun increaseScore() {
        _score.value = _score.value?.plus(SCORE_INCREASE)
    }

    fun isUserWordCorrect(playerWord: String): Boolean {
        if (playerWord.equals(currentWord, true)) {
            increaseScore()
            return true
        }
        return false
    }

    fun reinitializeData() {
        _score.value = 0
        _currentWordCount.value = 0
        wordsList.clear()
        getNextWord()
    }

    init {
        Log.d("GameViewModel", "ViewModel created")
        getNextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GameViewModel", "ViewModel destroyed")
    }
}
