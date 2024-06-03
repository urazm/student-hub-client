package ru.example.studenthubclient.network

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import ru.example.studenthubclient.models.PredictionResponse

interface ApiService {

    @FormUrlEncoded
    @POST("/predict_student_score")
    suspend fun predictStudentScore(
        @Field("mEdu") mEdu: String,
        @Field("fEdu") fEdu: String,
        @Field("studyTime") studyTime: String,
        @Field("failures") failures: String,
        @Field("support") support: String,
        @Field("higher") higher: String,
        @Field("absences") absences: String
    ): PredictionResponse
}