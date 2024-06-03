package ru.example.studenthubclient.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.example.studenthubclient.models.PredictionResponse
import ru.example.studenthubclient.models.StudentData
import ru.example.studenthubclient.network.RetrofitInstance
import ru.example.studenthubclient.repositories.StudentRepository

class DataStudentFormViewModel : ViewModel() {

    private val studentRepository = StudentRepository(RetrofitInstance.api)

    private val _prediction = MutableLiveData<PredictionResponse>()
    val prediction: LiveData<PredictionResponse> get() = _prediction

    fun submitData(mEdu: String, fEdu: String, studyTime: String, failures: String, support: String, higher: String, absences: String) {
        viewModelScope.launch {
            try {
                val response = studentRepository.predictStudentScore(mEdu, fEdu, studyTime, failures, support, higher, absences)
                _prediction.value = response
            } catch (e: Exception) {

            }
        }
    }
}