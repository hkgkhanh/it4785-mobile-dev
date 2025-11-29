package com.example.questionnairlab7

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    // map: questionIndex -> answer string (hoặc chọn kiểu Int cho option)
    private val _answers = MutableLiveData<MutableMap<Int, String>>(mutableMapOf())
    val answers: LiveData<MutableMap<Int, String>> get() = _answers

    fun setAnswer(questionIndex: Int, answer: String) {
        val map = _answers.value ?: mutableMapOf()
        map[questionIndex] = answer
        _answers.value = map
    }

    fun clearAnswers() {
        _answers.value = mutableMapOf()
    }
}