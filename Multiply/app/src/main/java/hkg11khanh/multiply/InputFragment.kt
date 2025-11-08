package hkg11khanh.multiply

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController

/**
 * A simple [Fragment] subclass.
 * Use the [InputFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InputFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button: Button = view.findViewById(R.id.bt_multiply)
        val number1: EditText = view.findViewById(R.id.number1)
        val number2: EditText = view.findViewById(R.id.number2)
        button.setOnClickListener {
//            Toast.makeText(this.requireContext(), n1.toString(), Toast.LENGTH_SHORT).show()
            val n1:Float = number1.text.toString().toFloatOrNull() ?: 0.0f
            val n2:Float = number2.text.toString().toFloatOrNull() ?: 0.0f
//            view.findNavController().navigate(R.id.action_inputFragment_to_multiplyFragment)
            val action =
                InputFragmentDirections.actionInputFragmentToMultiplyFragment(n1, n2)
            view.findNavController().navigate(action)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment InputFragment.
         */
        @JvmStatic
        fun newInstance() = InputFragment().apply {}
    }
}