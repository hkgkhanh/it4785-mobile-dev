package com.example.questionnairlab7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.questionnairlab7.SharedViewModel
import com.example.questionnairlab7.databinding.FragmentQuestionBinding

class Question2Fragment : Fragment() {
    private var _binding: FragmentQuestionBinding? = null
    private val binding get() = _binding!!
    private val sharedVM: SharedViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentQuestionBinding.inflate(inflater, container, false).also { _binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.questionText.text = "Question 2: Còn nước còn ... ?" // thay bằng câu thực tế
        binding.opt1.text = "... tát"
        binding.opt2.text = "... uống"
        binding.opt3.text = "... đất"
        binding.opt4.text = "đáp án khác"

        binding.btnNext.setOnClickListener {
            val selectedId = binding.optionsGroup.checkedRadioButtonId
            if (selectedId != -1) {
                val answer = when (selectedId) {
                    binding.opt1.id -> binding.opt1.text.toString()
                    binding.opt2.id -> binding.opt2.text.toString()
                    binding.opt3.id -> binding.opt3.text.toString()
                    binding.opt4.id -> binding.opt4.text.toString()
                    else -> ""
                }
                sharedVM.setAnswer(2, answer)
                findNavController().navigate(R.id.action_q2_to_q3)
            } else {
                // thông báo chọn đáp án (bổ sung nếu muốn)
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}