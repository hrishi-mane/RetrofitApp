package com.example.retrofitapp.question_list_feature.domain.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitapp.question_list_feature.data.repository.QuestionRepository
import com.example.retrofitapp.question_list_feature.domain.models.Questions
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class QuestionListViewModel
@Inject
constructor(
    private val questionRepository: QuestionRepository
) : ViewModel() {

    val questions: MutableLiveData<Questions> = MutableLiveData()

    fun getQuestions() {
        val response = questionRepository.getQuestions()
        response.enqueue(object : retrofit2.Callback<Questions> {
            override fun onResponse(call: Call<Questions>, response: Response<Questions>) {
                questions.postValue(response.body())
            }

            override fun onFailure(call: Call<Questions>, t: Throwable) {

            }
        })
    }
}