package com.example.retrofitapp.question_list_feature.data.data_source.external

import com.example.retrofitapp.question_list_feature.domain.models.Questions
import retrofit2.http.GET

interface RetroFitService {

    @GET("2.2/questions?key=ZiXCZbWaOwnDgpVT9Hx8IA((&order=desc&sort=activity&site=stackoverflow")
    fun getData(): retrofit2.Call<Questions>
}