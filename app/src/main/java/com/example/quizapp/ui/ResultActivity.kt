package com.example.quizapp.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.R
import com.example.quizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    private var userName = ""
    private var scoreEarn = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = intent.extras

        if (data != null) {
            userName = data.getString("name")!!
            scoreEarn = data.getInt("score")
            Log.d(
                "dataEarn",
                "onCreate: ${data.getString("name")} , result =  ${data.getInt("score")}"
            )
        }

        if (scoreEarn <= 5) {
            binding.resultLottie.setAnimation(R.raw.sadlottieanimation)
            binding.actualResult.text = "You have score $scoreEarn/10 \nNeed Hard Work !"
            binding.partcipantName.text = "You Loose $userName !"
        } else {
            binding.resultLottie.setAnimation(R.raw.victorylottieanimation)
            binding.actualResult.text = "You have score $scoreEarn/10"
            binding.partcipantName.text = "Congratulations $userName !"
        }

        binding.closeBtn.setOnClickListener{
            finish()
        }
    }
}