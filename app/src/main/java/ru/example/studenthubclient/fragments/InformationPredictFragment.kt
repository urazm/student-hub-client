package ru.example.studenthubclient.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.example.studenthubclient.R


class InformationPredictFragment : Fragment(R.layout.fragment_information_predict) {

    private lateinit var predictionTextView: TextView
    private lateinit var sharedPreferences: SharedPreferences

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        predictionTextView = view.findViewById(R.id.student_performance_predict)

        val savedPrediction = sharedPreferences.getFloat("prediction_score", -1f)
        if (savedPrediction != -1f) {
            predictionTextView.text = savedPrediction.toString()
        }
    }
}