package com.example.week6_softuser.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week6_softuser.R
import com.example.week6_softuser.adapter.UserAdapter
import com.example.week6_softuser.model.CommonData
import com.example.week6_softuser.model.Users

class HomeFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        loadUsers()
        val adapter = UserAdapter(CommonData.getStudent(),requireContext())
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        return view
    }

    private fun loadUsers() {
        CommonData.addStudent(Users("https://scontent.fktm8-1.fna.fbcdn.net/v/t1.0-9/107804296_1544706545690944_5336167260667260340_o.jpg?_nc_cat=110&ccb=2&_nc_sid=09cbfe&_nc_ohc=JYFtW-oNNTMAX8iYVFl&_nc_ht=scontent.fktm8-1.fna&oh=7d3106b468826a5b0ee39f528860705d&oe=60240847",
        "Mili Risal",20,"Kalanki","Female"))
        CommonData.addStudent(Users("https://images.indianexpress.com/2020/08/scholarship-759.jpg","Alisa Smith",22,"Kalanki","Female"))
        CommonData.addStudent(Users("https://www.fmjfee.com/i901fee/img/home/learn/learn_1.jpg","Rihana Risal",15,"Kalanki","Female"))
    }

}