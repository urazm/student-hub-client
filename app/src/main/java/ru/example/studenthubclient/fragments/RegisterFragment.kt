package ru.example.studenthubclient.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.example.studenthubclient.R

class RegisterFragment : Fragment(R.layout.fragment_register) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val registerBtn = view.findViewById<Button>(R.id.btn_register)
        registerBtn.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_dataStudentFormFragment)
        }

    }

}