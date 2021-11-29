package com.example.retrofitapp.question_list_feature.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapp.R
import com.example.retrofitapp.databinding.FragmentQuestionListViewholderBinding
import com.example.retrofitapp.question_list_feature.domain.models.Item
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class QuestionListAdapter : RecyclerView.Adapter<QuestionListAdapter.QuestionListViewHolder>() {

    var questionLists: List<Item> = ArrayList()

    inner class QuestionListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val fragmentQuestionListViewHolderBinding: FragmentQuestionListViewholderBinding =
            FragmentQuestionListViewholderBinding.bind(view)
        val questionName = fragmentQuestionListViewHolderBinding.viewHolderTextviewQuestion
        val authorName = fragmentQuestionListViewHolderBinding.viewholderTextviewName
        val postedDate = fragmentQuestionListViewHolderBinding.viewholderTextviewPostedDate
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_question_list_viewholder, parent, false)
        return QuestionListViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionListViewHolder, position: Int) {
        holder.questionName.text = questionLists[position].title
        holder.authorName.text = questionLists[position].owner.display_name

        val date = Date(questionLists[position].creation_date.toLong())
        val formattedDate =
            SimpleDateFormat("MMM dd yyyy, hh:mm aaa", Locale.getDefault()).format(date)
        holder.postedDate.text = formattedDate
    }

    override fun getItemCount(): Int {
        return questionLists.size
    }
}