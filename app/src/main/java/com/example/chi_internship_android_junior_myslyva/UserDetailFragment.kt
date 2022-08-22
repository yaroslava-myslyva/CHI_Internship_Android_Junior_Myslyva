package com.example.chi_internship_android_junior_myslyva

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.chi_internship_android_junior_myslyva.UserAdapter.Companion.KEY_USER_IS_STUDENT
import com.example.chi_internship_android_junior_myslyva.UserAdapter.Companion.KEY_USER_NAME_AGE
import com.example.chi_internship_android_junior_myslyva.UsersListFragment.Companion.preferences
import com.example.chi_internship_android_junior_myslyva.databinding.FragmentUserDetailsBinding

class UserDetailFragment : Fragment() {
    private lateinit var binding: FragmentUserDetailsBinding
    val A_STUDENT = "A student."
    val NOT_A_STUDENT = "Not a student."

    //TODO toolbar
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserDetailsBinding.inflate(layoutInflater)
        return inflater.inflate(R.layout.fragment_user_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textViewNameAge = getView()?.findViewById<TextView>(R.id.users_name_age)
        val textViewIsStudent = getView()?.findViewById<TextView>(R.id.user_is_a_student)

        textViewNameAge?.text = preferences.getString(KEY_USER_NAME_AGE, "")

        textViewIsStudent?.text =
            if (preferences.getBoolean(KEY_USER_IS_STUDENT, false)) {
                A_STUDENT
            } else
                NOT_A_STUDENT
    }
}
