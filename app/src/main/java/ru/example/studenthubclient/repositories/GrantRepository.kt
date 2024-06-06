package ru.example.studenthubclient.repositories

import ru.example.studenthubclient.models.GrantData
import ru.example.studenthubclient.models.PredictionResponse
import ru.example.studenthubclient.models.StudentData
import ru.example.studenthubclient.network.RetrofitInstance

class GrantRepository {
    private val apiService = RetrofitInstance.api

    suspend fun predictGrantScore(grantData: GrantData): PredictionResponse {
        return apiService.predictMinGrant(grantData)
    }
}