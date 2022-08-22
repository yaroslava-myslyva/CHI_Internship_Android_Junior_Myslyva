package com.example.chi_internship_android_junior_myslyva

import android.content.Context
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.CheckBox
import androidx.navigation.fragment.findNavController


class MyAdapter(
    private val fragment: UsersListFragment,
    private val context: Context?,
    private var onItemClickListener: OnItemClickListener,
    private val items: List<User>
) : RecyclerView.Adapter<MyAdapter.UserViewHolder>() {

    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {
        fun bind(user: User) {
            itemView.run {
                val userNameAge = findViewById<TextView>(R.id.users_name_age)
                val userIsStudent = findViewById<CheckBox>(R.id.is_student)
                userNameAge.text = "${user.name}, ${user.age} years old"
                userIsStudent.isChecked = user.isStudent
                userIsStudent.setOnCheckedChangeListener { _, isChecked ->
                    user.isStudent = isChecked
                }
                setOnClickListener {
                    fragment.findNavController().navigate(R.id.destination_user_details)
                    UsersListFragment.editor.putString(
                        UserAdapter.KEY_USER_NAME_AGE,
                        "${user.name}, ${user.age} years old"
                    )
                    UsersListFragment.editor.putBoolean(
                        UserAdapter.KEY_USER_IS_STUDENT,
                        user.isStudent
                    )
                }
            }
        }

        override fun onClick(view: View) {
            onItemClickListener.onItemClick(null, view, adapterPosition, view.id.toLong())
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = items[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int = items.size
}
