package com.example.tgufinalchronometer

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.coroutines.coroutineContext

class AuthorInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(authorInfo: AuthorInfo) {
        val nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        val surnameTextView: TextView = itemView.findViewById(R.id.surname_text_view)
        val gitTextView: TextView = itemView.findViewById(R.id.git_text_view)

        nameTextView.text = authorInfo.name
        surnameTextView.text = authorInfo.surame
        gitTextView.text = authorInfo.git



        val link = Uri.parse("https://github.com/gitkrom/CPC7.git")
        val intent = Intent(Intent.ACTION_VIEW, link)
        itemView.context.startActivity(intent)


        gitTextView.setOnClickListener{

            itemView.context.startActivity(intent)

        }


    }







}