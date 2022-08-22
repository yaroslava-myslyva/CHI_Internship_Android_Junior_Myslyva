package com.example.chi_internship_android_junior_myslyva

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.navigation.fragment.findNavController
import com.example.chi_internship_android_junior_myslyva.UsersListFragment.Companion.preferences
import com.example.chi_internship_android_junior_myslyva.databinding.FragmentUserDetailsBinding

class UserDetailFragment : Fragment() {
    private lateinit var binding: FragmentUserDetailsBinding
    private val aStudent = "A student."
    private val notStudent = "Not a student."

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserDetailsBinding.inflate(layoutInflater)
        return inflater.inflate(R.layout.fragment_user_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupData()
        setupToolbar()
    }

    private fun setupData() {
        val textViewNameAge = getView()?.findViewById<TextView>(R.id.users_name_age)
        val textViewIsStudent = getView()?.findViewById<TextView>(R.id.user_is_a_student)

        textViewNameAge?.text = preferences.getString(UserAdapter.KEY_USER_NAME_AGE, "")
        textViewIsStudent?.text =
            if (preferences.getBoolean(UserAdapter.KEY_USER_IS_STUDENT, false)) {
                aStudent
            } else {
                notStudent
            }
    }

    private fun setupToolbar() {
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {}

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                if (menuItem.itemId == android.R.id.home) {
                    findNavController().navigate(R.id.destination_users_list)
                }
                return false
            }
        })
    }
}
