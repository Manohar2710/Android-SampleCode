package com.manohar.myapplication.firstscreen

import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.manohar.myapplication.R
import com.manohar.myapplication.databinding.FragmentFirstScreenBinding

/**
 * A simple [Fragment] subclass.
 * Use the [FirstScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstScreenFragment : Fragment() {
//    private var param1: String? = null
//    private var param2: String? = null
    private lateinit var binding: FragmentFirstScreenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_first_screen,container,false)
//        return inflater.inflate(R.layout.fragment_first_screen, container, false)
        binding.btnSecondScreen.setOnClickListener { view:View->
            view.findNavController().navigate(FirstScreenFragmentDirections.actionFirstScreenFragmentToSecondScreenFragment())
        }
        return binding.root
    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment FirstScreenFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            FirstScreenFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}