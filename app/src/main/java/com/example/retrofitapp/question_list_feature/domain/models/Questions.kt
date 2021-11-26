package com.example.retrofitapp.question_list_feature.domain.models

data class Questions(
    val has_more: Boolean,
    val items: List<Item>,
    val quota_max: Int,
    val quota_remaining: Int
)