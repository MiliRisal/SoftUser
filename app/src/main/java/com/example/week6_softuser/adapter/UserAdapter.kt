package com.example.week6_softuser.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week6_softuser.R
import com.example.week6_softuser.model.Users
import de.hdodenhof.circleimageview.CircleImageView

class UserAdapter(
        val lstUsers: ArrayList<Users>,
        val context: Context
):RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    class UserViewHolder(view: View):RecyclerView.ViewHolder(view){
        val imgProfile : CircleImageView
        val tvName :TextView
        val tvAge :TextView
        val tvAddress : TextView
        val tvGender : TextView
        val imgDel: ImageView
        init {
            imgProfile = view.findViewById(R.id.imgProfile)
            tvName = view.findViewById(R.id.tvName)
            tvAge = view.findViewById(R.id.tvAge)
            tvAddress = view.findViewById(R.id.tvAddress)
            tvGender = view.findViewById(R.id.tvGender)
            imgDel = view.findViewById(R.id.imgDel)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.userlayout,parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = lstUsers[position]
        holder.tvName.text = user.userName
        holder.tvAge.text = user.userAge.toString()
        holder.tvAddress.text = user.userAddress
        holder.tvGender.text = user.userGender

        holder.imgDel.setOnClickListener{
            lstUsers.removeAt(position)
            notifyDataSetChanged()
        }
        Glide.with(context)
                .load(user.userImg)
                .into((holder.imgProfile))
    }

    override fun getItemCount(): Int {
        return lstUsers.size
    }
}