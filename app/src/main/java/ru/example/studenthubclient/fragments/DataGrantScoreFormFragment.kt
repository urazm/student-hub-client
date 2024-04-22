package ru.example.studenthubclient.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import ru.example.studenthubclient.R


class DataGrantScoreFormFragment : Fragment(R.layout.fragment_data_grant_score_form) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.button)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_dataGrantScoreFormFragment_to_informationPredictFragment)
        }

    }
}