package ru.example.studenthubclient.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import ru.example.studenthubclient.R


class InformationPredictFragment : Fragment(R.layout.fragment_information_predict) {

    private lateinit var predictionTextView: TextView
    private lateinit var predictionGrantTextView: TextView
    private lateinit var finalPredictTextView: TextView
    private lateinit var sharedPreferences: SharedPreferences

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        predictionTextView = view.findViewById(R.id.student_performance_predict)
        finalPredictTextView = view.findViewById(R.id.final_predict)

        val savedStudentScorePredoct = sharedPreferences.getFloat("prediction_score", -1f)
        if (savedStudentScorePredoct != -1f) {
            predictionTextView.text = savedStudentScorePredoct.toString()
        }

        predictionGrantTextView = view.findViewById(R.id.min_grant_predict)

        val savedGrantPredict = sharedPreferences.getFloat("min_grant_score", -1f)
        if (savedGrantPredict != -1f) {
            predictionGrantTextView.text = savedGrantPredict.toString()
        }

        if(savedGrantPredict > savedStudentScorePredoct) {
            finalPredictTextView.text = GRANT_FAIL
            finalPredictTextView.setTextColor(ContextCompat.getColor(requireContext(), COLOR_FAIL))
        }
        else finalPredictTextView.text = GRANT_SUCCESS
    }
    companion object {
        const val GRANT_SUCCESS = "Вы успешно пройдете на грант"
        const val GRANT_FAIL = "К сожалению Вы не пройдете на грант"
        const val COLOR_FAIL = android.R.color.holo_red_dark
    }
}

