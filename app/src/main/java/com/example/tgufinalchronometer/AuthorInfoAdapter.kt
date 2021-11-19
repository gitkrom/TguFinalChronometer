package com.example.tgufinalchronometer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AuthorInfoAdapter(private val infoList: List<AuthorInfo>): RecyclerView.Adapter<AuthorInfoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthorInfoViewHolder {
       val authorInfoListView=
           LayoutInflater.from(parent.context)
               .inflate(R.layout.author_info_list_item, parent, false)

        return AuthorInfoViewHolder(authorInfoListView)

    }

    override fun onBindViewHolder(holder: AuthorInfoViewHolder, position: Int) {
        val authorInfo=infoList[position]
        holder.bind(authorInfo)
    }

    override fun getItemCount(): Int {
        return infoList.size
    }
}