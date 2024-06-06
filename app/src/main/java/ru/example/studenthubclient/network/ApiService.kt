package ru.example.studenthubclient.network

import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import ru.example.studenthubclient.models.PredictionResponse
import ru.example.studenthubclient.models.StudentData
import ru.example.studenthubclient.models.GrantData

interface ApiService {
    @POST("/predict_student_score")
    suspend fun predictStudentScore(@Body data: StudentData): PredictionResponse

    @POST("/predict_grant_score")
    suspend fun predictMinGrant(@Body data: GrantData): PredictionResponse

}