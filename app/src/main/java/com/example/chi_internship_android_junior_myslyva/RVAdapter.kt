package com.example.chi_internship_android_junior_myslyva

import android.text.SpannableString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(val users: List<User>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind("${users[position].name}\n${users[position].age} years old.")
        holder.itemView.findViewById<CheckBox>(R.id.is_student)
            .setOnCheckedChangeListener { buttonView, isChecked ->
                users[position].isStudent = isChecked
            }
    }


    override fun getItemCount(): Int {
        return users.size
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(text: String) {
        itemView.findViewById<TextView>(R.id.users_name_age).text = text
        itemView.findViewById<CheckBox>(R.id.is_student)
    }
}
