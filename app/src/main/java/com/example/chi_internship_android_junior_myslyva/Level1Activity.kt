package com.example.chi_internship_android_junior_myslyva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.chi_internship_android_junior_myslyva.databinding.ActivityLevel1Binding

class Level1Activity : AppCompatActivity() {

    private lateinit var binding: ActivityLevel1Binding
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupListeners()
        setupObservers()
    }

    private fun setupBinding() {
        binding = ActivityLevel1Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupObservers() {
        val textView: TextView = binding.textView
        viewModel.counter.observe(this, {
            textView.text = it.toString()
        })
    }

    private fun setupListeners() {
        val button: Button = binding.button
        button.setOnClickListener { viewModel.increaseCounter() }
    }
}
