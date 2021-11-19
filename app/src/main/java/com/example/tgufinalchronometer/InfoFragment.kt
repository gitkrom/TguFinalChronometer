package com.example.tgufinalchronometer

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentContainer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class InfoFragment : Fragment() {


    @SuppressLint("CutPasteId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_info, container, false)

        val infoRecyclerViewFragment: RecyclerView? =
            view?.findViewById(R.id.info_recycler_view_fragment)

        val infoList: List<AuthorInfo> = listOf(
            AuthorInfo("Anton", "Dyshler",
                "https://github.com/gitkrom/CPC7.git")
        )


        val infoRecyclerView: RecyclerView=view.findViewById(R.id.info_recycler_view_fragment)
        infoRecyclerView.layoutManager=LinearLayoutManager(context,
        LinearLayoutManager.VERTICAL, false)

        infoRecyclerViewFragment?.adapter = AuthorInfoAdapter(infoList)





        return view
    }




}