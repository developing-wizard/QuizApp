package com.example.quizapp.utils

import com.example.quizapp.R
import com.example.quizapp.model.Questions

object Constants {

    fun getQuestions(): MutableList<Questions> {
        val questions = mutableListOf<Questions>()

        val quest1 = Questions(
            1, "Which planet is known as the Red Planet?", R.drawable.questions1,
            "Earth", "Jupiter", "Mars", "Venus", 3
        )
        questions.add(quest1)
        val quest2 = Questions(
            2, "What is the capital of Pakistan?", R.drawable.questions2,
            "Lahore", "Karachi", "Peshawar", "Islamabad", 4
        )
        questions.add(quest2)
        val quest3 = Questions(
            3, "Who wrote the famous play \"Romeo and Juliet\"?", R.drawable.questions3,
            "William Wordsworth", " William Shakespeare", "Charles Dickens", "Mark Twain", 2
        )
        questions.add(quest3)

        val quest4 = Questions(
            4, "Which gas do plants use in photosynthesis?", R.drawable.questions4,
            "Carbon dioxide", "Oxygen", "Nitrogen", "Hydrogen", 1
        )
        questions.add(quest4)

        val quest5 = Questions(
            5, "What is the largest ocean on Earth?", R.drawable.questions5,
            "Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean", 4
        )
        questions.add(quest5)
        val quest6 = Questions(
            6, "What is the square root of 64?", R.drawable.questions6,
            "6", "8", "7", "9", 2
        )
        questions.add(quest6)
        val quest7 = Questions(
            7, "Which element has the chemical symbol 'O'?", R.drawable.questions7,
            "Gold", "Oxygen", "Osmium", "Octane", 2
        )
        questions.add(quest7)
        val quest8 = Questions(
            8, "What is the national sport of Pakistan?", R.drawable.questions8,
            "Hockey", "Cricket", "Football", "Kabaddi", 1
        )
        questions.add(quest8)

        val quest9 = Questions(
            9, "Who is known as the founder of Microsoft?", R.drawable.questions9,
            "Steve Jobs", "Jeff Bezos", "Bill Gates", "Elon Musk", 3
        )
        questions.add(quest9)

        val quest10 = Questions(
            10, "What is the chemical formula of water?", R.drawable.questions10,
            "H2O", "CO2", "NaCl", "CH4", 1
        )
        questions.add(quest10)

        return questions
    }


}