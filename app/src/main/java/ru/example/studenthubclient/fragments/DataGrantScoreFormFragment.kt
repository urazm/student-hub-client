package ru.example.studenthubclient.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import ru.example.studenthubclient.R
import ru.example.studenthubclient.viewmodels.DataGrantScoreFormViewModel
import ru.example.studenthubclient.viewmodels.DataStudentFormViewModel


class DataGrantScoreFormFragment : Fragment(R.layout.fragment_data_grant_score_form) {
    private val viewModel: DataGrantScoreFormViewModel by viewModels()
    private lateinit var sharedPreferences: SharedPreferences
    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val averageScoreEditText = view.findViewById<EditText>(R.id.averageScore)
        val placeCountEditText = view.findViewById<EditText>(R.id.placeCount)
        val applyCountEditText = view.findViewById<EditText>(R.id.applyCount)

        val fillButton = view.findViewById<Button>(R.id.grant_fill)

        fillButton.setOnClickListener {
            val averageScoreStr = averageScoreEditText.text.toString()
            val placeCountStr = placeCountEditText.text.toString()
            val applyCountStr = applyCountEditText.text.toString()

            val averageScore = averageScoreStr.toIntOrNull()
            val placeCount = placeCountStr.toIntOrNull()
            val applyCount = applyCountStr.toIntOrNull()
            Log.d("grant", "Button clicked")
            Log.d("grant", "Data: $averageScore, $placeCount, $applyCount")
            if (averageScore == null || placeCount == null || applyCount == null) {
                Toast.makeText(requireContext(), "Please enter valid numbers", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            viewModel.submitData(averageScore, placeCount, applyCount)
        }

        viewModel.prediction.observe(viewLifecycleOwner, Observer { prediction ->
            Log.d("grant", prediction.score.toString())
            if (prediction != null) {
                Log.d("PREDICTION NOT NULL GRANT", prediction.score.toString())
                savePrediction(prediction.score)
                Toast.makeText(requireContext(), "Prediction: ${prediction.score}", Toast.LENGTH_LONG).show()
                val savedPrediction = sharedPreferences.getFloat("min_grant_score", -1f)
                Log.d("grant", "Saved prediction: $savedPrediction")
                findNavController().navigate(R.id.action_dataGrantScoreFormFragment_to_informationPredictFragment)
            }
        })
    }
    private fun savePrediction(score: Float) {
        with(sharedPreferences.edit()) {
            putFloat("min_grant_score", score)
            apply()
        }
    }
}