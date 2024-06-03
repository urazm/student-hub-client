package ru.example.studenthubclient.fragments

import android.os.Bundle
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

            viewModel.submitData(mEduText, fEduText, studyTimeText, failuresText, supportText, higherText, absencesText)
        }

        viewModel.prediction.observe(viewLifecycleOwner, Observer { prediction ->
            if (prediction != null) {
                // TODO: Сохранить предикт и передать в финальный фрагмент
                Toast.makeText(requireContext(), "Prediction: ${prediction.score}", Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_dataStudentFormFragment_to_dataGrantScoreFormFragment)
            }
        })
    }
}
