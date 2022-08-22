package com.example.chi_internship_android_junior_myslyva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chi_internship_android_junior_myslyva.databinding.ActivityLevel2Binding

class Level2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityLevel2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
    }

    private fun setupBinding() {
        binding = ActivityLevel2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
