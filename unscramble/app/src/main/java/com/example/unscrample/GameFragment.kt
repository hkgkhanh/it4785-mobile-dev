package com.example.unscrample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.unscramble.MAX_NO_OF_WORDS
import com.example.unscramble.allWordsList
import com.example.unscrample.databinding.FragmentGameBinding
import androidx.fragment.app.viewModels
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding
    private val viewModel: GameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.submit.setOnClickListener { onSubmitWord() }
        binding.skip.setOnClickListener { onSkipWord() }

        // LiveData Observers
        viewModel.currentScrambledWord.observe(viewLifecycleOwner) { newWord ->
            binding.textViewUnscrambledWord.text = newWord
        }

        viewModel.score.observe(viewLifecycleOwner) { newScore ->
            binding.score.text = getString(R.string.score, newScore)
        }

        viewModel.currentWordCount.observe(viewLifecycleOwner) { newCount ->
            binding.wordCount.text = getString(
                R.string.word_count, newCount, MAX_NO_OF_WORDS
            )
        }
    }

    private fun onSubmitWord() {
        val playerWord = binding.textInputEditText.text.toString()

        if (viewModel.isUserWordCorrect(playerWord)) {
            setErrorTextField(false)
            if (!viewModel.nextWord()) {
                showFinalScoreDialog()
            }
        } else {
            setErrorTextField(true)
        }
    }

    private fun onSkipWord() {
        if (viewModel.nextWord()) {
            setErrorTextField(false)
        } else {
            showFinalScoreDialog()
        }
    }

    private fun restartGame() {
        viewModel.reinitializeData()
        setErrorTextField(false)
    }

    private fun exitGame() {
        activity?.finish()
    }

    private fun setErrorTextField(error: Boolean) {
        if (error) {
            binding.textField.isErrorEnabled = true
            binding.textField.error = getString(R.string.try_again)
        } else {
            binding.textField.isErrorEnabled = false
            binding.textInputEditText.text = null
        }
    }

    private fun showFinalScoreDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.congratulations))
            .setMessage(getString(R.string.you_scored, viewModel.score.value))
            .setCancelable(false)
            .setNegativeButton(R.string.exit) { _, _ -> exitGame() }
            .setPositiveButton(R.string.play_again) { _, _ -> restartGame() }
            .show()
    }
}
