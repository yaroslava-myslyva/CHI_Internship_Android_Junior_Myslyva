package com.example.chi_internship_android_junior_myslyva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Level1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level1)

        findViewById<Button>(R.id.button).setOnClickListener {
            findViewById<TextView>(R.id.textView).text =
                findViewById<TextView>(R.id.textView).text.toString().toInt().inc().toString()

        }
    }
}