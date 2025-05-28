package com.example.quizapp.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.quizapp.R
import com.example.quizapp.databinding.ActivityQuestionsBinding
import com.example.quizapp.model.Questions
import com.example.quizapp.utils.Constants

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityQuestionsBinding
    private var currentSelectedAnswerPosition: Int = -1
    private var questionsList: MutableList<Questions> = mutableListOf()
    private val optionsList = mutableListOf<TextView>()
    private var correctedAnswer: Int = 0
    private var counter = 0
    private var questionNumber = 0
    private var isAnswerSelected: Boolean = false
    private var userName : String = "null"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
val data = intent.extras
        if (data !=null){
            userName = data.getString("name")!!
            Log.d("TAG", "onCreate: $userName")
        }
        optionsList.add(binding.optionOne)
        optionsList.add(binding.optionTwo)
        optionsList.add(binding.optionThree)
        optionsList.add(binding.optionFour)
        funSetOnClickListeners()
        questionsList = Constants.getQuestions()
        Log.d("Questions ", "onCreate: $questionsList")
        setQuestion(counter)


    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.option_one -> {
                selectedOption(binding.optionOne, 1)
            }

            R.id.option_two -> {
                selectedOption(binding.optionTwo, 2)

            }

            R.id.option_three -> {
                selectedOption(binding.optionThree, 3)

            }

            R.id.option_four -> {
                selectedOption(binding.optionFour, 4)

            }

            R.id.check_answer_btn -> {
                if (currentSelectedAnswerPosition == -1 && !isAnswerSelected) {
                    Toast.makeText(this, "Please select answer", Toast.LENGTH_SHORT).show()
                    return
                }
                if (!isAnswerSelected) {
                    checkAnswer(currentSelectedAnswerPosition)
                    currentSelectedAnswerPosition = -1
                } else {
                    if (counter != questionsList.size)
                        setQuestion(counter)
                    else{
                        Intent(this,ResultActivity::class.java).also{
                            it.putExtra("name",userName)
                            it.putExtra("score",correctedAnswer)
                            startActivity(it)
                            finish()
                        }
                    }
                }

            }
        }
    }

    private fun funSetOnClickListeners() {
        binding.optionOne.setOnClickListener(this)
        binding.optionTwo.setOnClickListener(this)
        binding.optionThree.setOnClickListener(this)
        binding.optionFour.setOnClickListener(this)
        binding.checkAnswerBtn.setOnClickListener(this)
    }

    private fun setQuestion(index: Int) {
        resetOption()
        val questions = questionsList[index]
        binding.questionText.text = questions.question
        binding.imageView.setImageResource(questions.image)
        binding.questionsProgress.progress = index + 1
        binding.progressTextView.text = "${index + 1}/${binding.questionsProgress.max}"
        binding.optionOne.text = questions.optionOne
        binding.optionTwo.text = questions.optionTwo
        binding.optionThree.text = questions.optionThree
        binding.optionFour.text = questions.optionFour
        if (index == questionsList.size)
            binding.checkAnswerBtn.text = "Finish"
        else
            binding.checkAnswerBtn.text = "Check"
        questionNumber = counter
        counter++
        isAnswerSelected = false

    }

    private fun resetOption() {
        for (options in optionsList) {
            options.setTextColor(Color.WHITE)
            options.background = ContextCompat.getDrawable(this, R.drawable.roundcornertextfield)

        }
    }

    private fun selectedOption(textView: TextView, selectedOptionNumber: Int) {
        resetOption()
        currentSelectedAnswerPosition = selectedOptionNumber
        textView.setTextColor(Color.BLACK)
        textView.background = ContextCompat.getDrawable(this, R.drawable.selected_option_color)
    }

    private fun checkAnswer(selectedAnswer: Int) {
        isAnswerSelected = true
        if (selectedAnswer == questionsList[questionNumber].correctAnswer) {
            correctedAnswer++
            correctAnswerUi(selectedAnswer)
        } else {
            wrongAnswerUi(selectedAnswer)
            showSolution()
        }
        if (counter != questionsList.size)
            binding.checkAnswerBtn.text = "Next"
        else {
            binding.checkAnswerBtn.text = "Finish"
            Log.d("checkAnswer", "checkAnswer: $correctedAnswer")
        }
    }

    private fun showSolution() {
        val correctAnswer = questionsList[questionNumber].correctAnswer
        correctAnswerUi(correctAnswer)
    }

    private fun correctAnswerUi(answer: Int) {
        when (answer) {
            1 -> {
                binding.optionOne.background =
                    ContextCompat.getDrawable(this, R.drawable.correct_option_color)
            }

            2 -> {
                binding.optionTwo.background =
                    ContextCompat.getDrawable(this, R.drawable.correct_option_color)

            }

            3 -> {
                binding.optionThree.background =
                    ContextCompat.getDrawable(this, R.drawable.correct_option_color)

            }

            4 -> {
                binding.optionFour.background =
                    ContextCompat.getDrawable(this, R.drawable.correct_option_color)
            }

        }

    }

    private fun wrongAnswerUi(answer: Int) {
        when (answer) {
            1 -> {
                binding.optionOne.background =
                    ContextCompat.getDrawable(this, R.drawable.wrong_option_color)
            }

            2 -> {
                binding.optionTwo.background =
                    ContextCompat.getDrawable(this, R.drawable.wrong_option_color)

            }

            3 -> {
                binding.optionThree.background =
                    ContextCompat.getDrawable(this, R.drawable.wrong_option_color)

            }

            4 -> {
                binding.optionFour.background =
                    ContextCompat.getDrawable(this, R.drawable.wrong_option_color)
            }

        }

    }

}