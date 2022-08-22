package com.example.chi_internship_android_junior_myslyva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.chi_internship_android_junior_myslyva.databinding.ActivityLevel2Binding

class Level2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityLevel2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupNavController()
    }

    private fun setupBinding() {
        binding = ActivityLevel2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupNavController() {
        val navController = binding.navHostFragment.getFragment<NavHostFragment>().navController
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.destination_users_list))
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
}
