package com.reshika.softusersoftwarica.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.reshika.softusersoftwarica.Adapter.StudentListAdapter
import com.reshika.softusersoftwarica.Dashboard.DashboardActivity
import com.reshika.softusersoftwarica.Model.Student
import com.reshika.softusersoftwarica.R


class Home_Fragment : Fragment() {
    // TODO: Rename and change types of parameters


    private lateinit var recyclerView:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_, container, false)
        recyclerView =view.findViewById(R.id.recyclerView)

        Student("Reshika Shrestha","20","lokanthali","Female")
        val adapter = StudentListAdapter(this.context!!, DashboardActivity.lisfOfStudent)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.context)

        return view;
    }


}