package ru.example.studenthubclient.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.example.studenthubclient.models.PredictionResponse
import ru.example.studenthubclient.models.StudentData
import ru.example.studenthubclient.repositories.StudentRepository

class DataStudentFormViewModel : ViewModel() {

    private val studentRepository = StudentRepository()

    private val _prediction = MutableLiveData<PredictionResponse>()
    val prediction: LiveData<PredictionResponse> get() = _prediction

    fun submitData(mEdu: String, fEdu: String, studyTime: String, failures: String,
                   support: String, higher: String, absences: String) {
        val studentData = StudentData(mEdu, fEdu, studyTime, failures, support, higher, absences)
        viewModelScope.launch {
            try {
                val response = studentRepository.predictStudentScore(studentData)
                Log.d("DataStudentFormViewModel", "Response: $response")
                _prediction.value = response
            } catch (e: Exception) {
                Log.e("DataStudentFormViewModel", "Error submitting data", e)
            }
        }
    }
}