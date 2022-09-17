package khan.sajad.example.quiztime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import khan.sajad.example.quiztime.Constants.getQuestions
import khan.sajad.example.quiztime.R.drawable
import khan.sajad.example.quiztime.Result
import khan.sajad.example.quiztime.databinding.ActivityMainBinding
import khan.sajad.example.quiztime.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizQuestionsBinding
    private val questions = getQuestions()
    private var position = 1
    private var submitted = false
    private var correctOption: TextView? = null
    private var selectedOption: TextView? = null
    private var correct = 0
    private var name: String?=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        name = intent.extras?.getString("nameKey")
        setInitialContent()
        binding.optionOne.setOnClickListener {
            setSelectedOption(it as TextView)
        }
        binding.optionTwo.setOnClickListener {
            setSelectedOption(it as TextView)
        }
        binding.optionThree.setOnClickListener {
            setSelectedOption(it as TextView)
        }
        binding.optionFour.setOnClickListener {
            setSelectedOption(it as TextView)
        }

        binding.submitBtn.setOnClickListener{
            if(!submitted){
                if (selectedOption != null) {
                    setCorrectOption()
                    if(correctOption == selectedOption){
                        correctOption?.background = ContextCompat.getDrawable(this,
                            R.drawable.correct_option_bg)
                        correct++
                    }
                    else{
                        correctOption?.background = ContextCompat.getDrawable(this,
                            R.drawable.correct_option_bg)
                        selectedOption?.background = ContextCompat.getDrawable(this,
                            R.drawable.wrong_option_bg)
                    }
                    submitted = true
                    binding.submitBtn.text = "Next"
                }
                else{
                    Toast.makeText(this, "Select an option", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                if(position==questions.size){
                    val intent = Intent(this, Result::class.java)
                    intent.putExtra("score", correct.toString())
                    intent.putExtra("name", name)
                    intent.putExtra("maxScore", questions.size.toString())
                    startActivity(intent)
                    finish()
                }
                else{
                    position++
                    setInitialContent()
                    submitted = false
                    selectedOption = null
                }
            }
        }
    }

    private fun setSelectedOption(view: TextView) {
        view.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
        selectedOption = view
        if(view != binding.optionOne){
            binding.optionOne.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
        if(view != binding.optionTwo){
            binding.optionTwo.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
        if(view != binding.optionThree){
            binding.optionThree.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
        if(view != binding.optionFour){
            binding.optionFour.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    private fun setInitialContent(){
        binding.tvQuestion.text = questions[position-1].question
        binding.ivFlag.setImageResource(questions[position-1].image)
        binding.progressBar.progress = position
        binding.tvProgress.text = getString(R.string.str_progress,
            position.toString(),
            (questions.size).toString())
        binding.optionOne.text = questions[position-1].optionOne
        binding.optionTwo.text = questions[position-1].optionTwo
        binding.optionThree.text = questions[position-1].optionThree
        binding.optionFour.text = questions[position-1].optionFour
        binding.submitBtn.text = getString(R.string.submit)
        binding.optionOne.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        binding.optionTwo.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        binding.optionThree.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        binding.optionFour.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)

    }
    private fun setCorrectOption(){
        if(questions[position-1].optionCorrect == 1) correctOption = binding.optionOne
        else if(questions[position-1].optionCorrect == 2) correctOption = binding.optionTwo
        else if(questions[position-1].optionCorrect == 3) correctOption = binding.optionThree
        else  correctOption = binding.optionFour
    }
}