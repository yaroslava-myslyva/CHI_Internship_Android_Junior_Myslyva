package com.example.chi_internship_android_junior_myslyva

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.CheckBox
import androidx.navigation.fragment.findNavController


class UserAdapter(
    private val fragment: UsersListFragment,
    private val items: List<User>
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
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
                        KEY_USER_NAME_AGE,
                        "${user.name}, ${user.age} years old"
                    )
                    UsersListFragment.editor.putBoolean(
                        KEY_USER_IS_STUDENT,
                        user.isStudent
                    )
                }
            }
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

    companion object {
        const val KEY_USER_NAME_AGE = "KEY_USER_NAME_AGE"
        const val KEY_USER_IS_STUDENT = "KEY_USER_IS_STUDENT"
    }
}
