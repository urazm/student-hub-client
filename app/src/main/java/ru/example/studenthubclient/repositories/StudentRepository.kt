package ru.example.studenthubclient.repositories

import ru.example.studenthubclient.models.PredictionResponse
import ru.example.studenthubclient.network.ApiService

class StudentRepository(private val apiService: ApiService) {

    suspend fun predictStudentScore(mEdu: String, fEdu: String, studyTime: String, failures: String, support: String, higher: String, absences: String): PredictionResponse {
        return apiService.predictStudentScore(mEdu, fEdu, studyTime, failures, support, higher, absences)
    }
}