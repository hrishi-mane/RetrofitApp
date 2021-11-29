package com.example.retrofitapp.question_list_feature.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.retrofitapp.R
import com.example.retrofitapp.databinding.FragmentQuestionListBinding
import com.example.retrofitapp.question_list_feature.domain.viewmodel.QuestionListViewModel

class QuestionList : Fragment(R.layout.fragment_question_list) {
    private val questionListViewModel: QuestionListViewModel by viewModels()
    private lateinit var fragmentQuestionListBinding: FragmentQuestionListBinding
    private var questionListAdapter = QuestionListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentQuestionListBinding = FragmentQuestionListBinding.bind(view)

        val questionList = fragmentQuestionListBinding.questionList
        questionList.adapter = questionListAdapter

        questionListViewModel.getQuestions()

        questionListViewModel.questions.observe(viewLifecycleOwner, { questions ->
            questionListAdapter.questionLists = questions.items
        })
    }
}