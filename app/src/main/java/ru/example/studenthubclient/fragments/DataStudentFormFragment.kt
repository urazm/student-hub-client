package ru.example.studenthubclient.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import ru.example.studenthubclient.R
import ru.example.studenthubclient.viewmodels.DataStudentFormViewModel

class DataStudentFormFragment : Fragment(R.layout.fragment_data_student_form) {

    private val viewModel: DataStudentFormViewModel by viewModels()
    private lateinit var sharedPreferences: SharedPreferences
    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mEdu = view.findViewById<EditText>(R.id.mEdu)
        val fEdu = view.findViewById<EditText>(R.id.fEdu)
        val studyTime = view.findViewById<EditText>(R.id.studyTime)
        val failures = view.findViewById<EditText>(R.id.failures)
        val support = view.findViewById<EditText>(R.id.support)
        val higher = view.findViewById<EditText>(R.id.higher)
        val absences = view.findViewById<EditText>(R.id.absences)
        val fillButton = view.findViewById<Button>(R.id.button_student_fill)

        fillButton.setOnClickListener {
            val mEduText = mEdu.text.toString()
            val fEduText = fEdu.text.toString()
            val studyTimeText = studyTime.text.toString()
            val failuresText = failures.text.toString()
            val supportText = support.text.toString()
            val higherText = higher.text.toString()
            val absencesText = absences.text.toString()

            Log.d("student", "Button clicked")
            Log.d("student", "Data: $mEduText, $fEduText, $studyTimeText, $failuresText, $supportText, $higherText, $absencesText")

            viewModel.submitData(mEduText, fEduText, studyTimeText, failuresText, supportText, higherText, absencesText)
        }

        viewModel.prediction.observe(viewLifecycleOwner, Observer { prediction ->
            Log.d("student", prediction.score.toString())
            if (prediction != null) {
                savePrediction(prediction.score)
                Toast.makeText(requireContext(), "Prediction: ${prediction.score}", Toast.LENGTH_LONG).show()
                val savedPrediction = sharedPreferences.getFloat("prediction_score", -1f)
                Log.d("student", "Saved prediction: $savedPrediction")
                findNavController().navigate(R.id.action_dataStudentFormFragment_to_dataGrantScoreFormFragment)
            }
        })
    }
    private fun savePrediction(score: Float) {
        with(sharedPreferences.edit()) {
            putFloat("prediction_score", score)
            apply()
        }
    }

}
