package com.example.questionnairlab7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.questionnairlab7.SharedViewModel
import com.example.questionnairlab7.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private val sharedVM: SharedViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentResultBinding.inflate(inflater, container, false).also { _binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Observe answers and display
        sharedVM.answers.observe(viewLifecycleOwner) { map ->
            // Build display string
            val sb = StringBuilder()
            // ensure show in question order
            for (i in 1..3) {
                val a = map[i] ?: "(no answer)"
                sb.append("Question $i: $a\n")
            }
            binding.tvAnswers.text = sb.toString()
        }

        // Back to Welcome AND clear back stack so only Welcome remains
        binding.btnBackToWelcome.setOnClickListener {
            val navController = findNavController()
            val navOptions = NavOptions.Builder()
                // popUpTo welcome inclusive = true will remove existing welcome,
                // then we navigate to welcome so it's the only entry.
                .setPopUpTo(R.id.welcomeFragment, true)
                .build()
            navController.navigate(R.id.welcomeFragment, null, navOptions)
            // Optionally clear answers
            sharedVM.clearAnswers()
        }

        // Restart: simply pop up to welcome but keep it (non-inclusive), then go q1
        binding.btnRestart.setOnClickListener {
            val navController = findNavController()
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.welcomeFragment, true)
                .build()
            navController.navigate(R.id.welcomeFragment, null, navOptions)
            sharedVM.clearAnswers()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}