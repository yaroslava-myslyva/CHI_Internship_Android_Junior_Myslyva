package com.example.chi_internship_android_junior_myslyva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chi_internship_android_junior_myslyva.databinding.ActivityLevel2Binding

class Level2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityLevel2Binding
    val usersList: List<User> = mutableListOf(
        User("Vasyl", 57),
        User("Kateryna", 12),
        User("Larysa", 69),
        User("Ivan", 18),
        User("Sergij", 22),
        User("Nadija", 33),
        User("Stepan", 45)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupRecyclerView()

    }

    private fun setupBinding() {
        binding = ActivityLevel2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupRecyclerView(){
        binding.recycleView.run{
            adapter = RVAdapter(usersList)
            layoutManager = LinearLayoutManager(this@Level2Activity)
            hasFixedSize()
            addItemDecoration(
                DividerItemDecoration(this@Level2Activity, RecyclerView.VERTICAL)
            )
        }

    }
}