package com.example.retrofitapp.question_list_feature.data.repository

import com.example.retrofitapp.question_list_feature.data.data_source.external.RetroFitService

class QuestionRepository
constructor(
    private val retrofitService: RetroFitService
) {
    fun getQuestions() = retrofitService.getData()
}