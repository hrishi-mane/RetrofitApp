package com.example.retrofitapp.question_list_feature.domain.models

data class Owner(
    val accept_rate: Int,
    val display_name: String,
    val link: String,
    val profile_image: String,
    val reputation: Int,
    val user_id: Int,
    val user_type: String
)