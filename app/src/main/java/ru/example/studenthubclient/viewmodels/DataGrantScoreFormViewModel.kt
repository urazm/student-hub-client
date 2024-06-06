package ru.example.studenthubclient.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.example.studenthubclient.models.GrantData
import ru.example.studenthubclient.models.PredictionResponse
import ru.example.studenthubclient.repositories.GrantRepository

class DataGrantScoreFormViewModel : ViewModel() {
    private val grantRepository = GrantRepository()

    private val _prediction = MutableLiveData<PredictionResponse>()
    val prediction: LiveData<PredictionResponse> get() = _prediction

    fun submitData(averageScoreCourse: Int,
                   placeCount: Int,
                   studentApplyCount: Int) {
        val grantData = GrantData(averageScoreCourse.toInt(), placeCount.toInt(), studentApplyCount.toInt())
        Log.d("GrantData", "Data being sent: $grantData")
        Log.d("GrantData", "data submit: $averageScoreCourse, $placeCount, $studentApplyCount")
        viewModelScope.launch {
            try {
                val response = grantRepository.predictGrantScore(grantData)
                Log.d("GrantStudentViewModel", "Response: $response")
                _prediction.value = response
            } catch (e: Exception) {
                Log.e("GrantStudentViewModel", "Error submitting data", e)
            }
        }
    }
}