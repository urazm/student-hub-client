package ru.example.studenthubclient.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import ru.example.studenthubclient.R


class DataStudentFormFragment : Fragment(R.layout.fragment_data_student_form) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fillButton = view.findViewById<Button>(R.id.button_student_fill)
        fillButton.setOnClickListener {
            findNavController().navigate(R.id.action_dataStudentFormFragment_to_dataGrantScoreFormFragment)
        }

    }
}