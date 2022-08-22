package com.example.chi_internship_android_junior_myslyva

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.chi_internship_android_junior_myslyva.UsersListFragment.Companion.editor
import androidx.navigation.fragment.findNavController

class UserAdapter(
    private val fragment: UsersListFragment,
    private val context: Context,
    private val usersList: List<User>
) : BaseAdapter() {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return usersList.size
    }

    override fun getItem(position: Int): Any {
        return usersList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val usersListItemView: View = inflater.inflate(R.layout.view_holder, null)
        val usersListItem: User = usersList[position]
        val userNameAge = usersListItemView.findViewById(R.id.users_name_age) as TextView
        val userIsStudent = usersListItemView.findViewById(R.id.is_student) as CheckBox

        userNameAge.text = "${usersListItem.name}, ${usersListItem.age} years old"
        userIsStudent.isChecked = usersListItem.isStudent
        userIsStudent.setOnCheckedChangeListener { buttonView, isChecked ->
            usersListItem.isStudent = isChecked
        }
        usersListItemView.setOnClickListener {
            fragment.findNavController().navigate(R.id.destination_user_details)
            editor.putString(KEY_USER_NAME_AGE, userNameAge.text.toString())
            editor.putBoolean(KEY_USER_IS_STUDENT, usersListItem.isStudent)
        }
        return usersListItemView
    }

    companion object {
        const val KEY_USER_NAME_AGE = "KEY_USER_NAME_AGE"
        const val KEY_USER_IS_STUDENT = "KEY_USER_IS_STUDENT"
    }
}
