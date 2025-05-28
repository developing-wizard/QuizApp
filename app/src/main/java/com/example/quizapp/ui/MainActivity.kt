package com.example.quizapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startBtn.setOnClickListener {
            if (binding.userName.text?.isNotEmpty() == true) {
                 Intent(this, QuestionsActivity::class.java).also {
                     it.putExtra("name", binding.userName.text.toString())
                     startActivity(it)
                     finish()
                 }
            } else {
                Toast.makeText(this, "Please enter your Name", Toast.LENGTH_SHORT).show()
            }

        }


    }
}