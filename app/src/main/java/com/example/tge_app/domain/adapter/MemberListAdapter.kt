package com.example.tge_app.domain.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tge_app.R
import com.example.tge_app.data.local.models.Membre

class MemberListAdapter(internal var context: Context,
                        var memberList: List<Membre>) : RecyclerView.Adapter<MemberListAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        internal var img_member: ImageView
        internal var txt_member: TextView
        init {
            img_member = itemView.findViewById(R.id.member_image) as ImageView
            txt_member = itemView.findViewById(R.id.member_name) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.member_list_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return memberList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(memberList[position].photo).into(holder.img_member)
        holder.txt_member.text = memberList[position].nom
    }
}