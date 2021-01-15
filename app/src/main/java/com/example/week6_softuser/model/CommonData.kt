package com.example.week6_softuser.model

object CommonData {
    var liststudent = ArrayList<Users>()
    fun addStudent(users : Users){
        liststudent.add(users)
    }
    fun getStudent() : ArrayList<Users>{
        return liststudent
    }
}