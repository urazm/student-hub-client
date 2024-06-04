package ru.example.studenthubclient.repositories

import android.util.Log
import ru.example.studenthubclient.models.PredictionResponse
import ru.example.studenthubclient.models.StudentData
import ru.example.studenthubclient.network.ApiService
import ru.example.studenthubclient.network.RetrofitInstance

class StudentRepository {

    private val apiService = RetrofitInstance.api

    suspend fun predictStudentScore(studentData: StudentData): PredictionResponse {
        return apiService.predictStudentScore(studentData)
    }
}