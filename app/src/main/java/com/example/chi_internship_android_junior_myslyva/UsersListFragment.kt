package com.example.chi_internship_android_junior_myslyva

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.chi_internship_android_junior_myslyva.databinding.FragmentUsersListBinding

class UsersListFragment : Fragment() {
    private lateinit var binding: FragmentUsersListBinding

    private val usersList: List<User> = mutableListOf(
        User("Vasyl", 57),
        User("Kateryna", 12),
        User("Larysa", 69),
        User("Ivan", 18),
        User("Sergij", 22),
        User("Nadija", 33),
        User("Stepan", 45)
    )

    companion object {
        lateinit var preferences: SharedPreferences
        lateinit var editor: SharedPreferences.Editor
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUsersListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSharedPreferences()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.lvUsersList.run {
            adapter = UserAdapter(this@UsersListFragment, context, usersList)
        }
    }

    private fun setupSharedPreferences() {
        activity?.run {
            preferences = this.getSharedPreferences("preferences", AppCompatActivity.MODE_PRIVATE)
        }
        editor = preferences.edit()
        if (preferences.all.isNotEmpty()) {
            usersList.forEach {
                it.isStudent = preferences.getBoolean("${it.name}${it.age}", false)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        usersList.forEach { editor.putBoolean("${it.name}${it.age}", it.isStudent) }
        editor.commit()
    }
}
