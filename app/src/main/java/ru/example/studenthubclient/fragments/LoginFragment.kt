package ru.example.studenthubclient.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import ru.example.studenthubclient.R


class LoginFragment : Fragment(R.layout.fragment_login) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val registerBtn = view.findViewById<Button>(R.id.btn_login)
        registerBtn.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_dataStudentFormFragment)
        }

    }
}