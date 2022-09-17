package khan.sajad.example.quiztime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import khan.sajad.example.quiztime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var enteredName: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val emptyText = binding.inputValue.text
        binding.startBtn.setOnClickListener{
            if (emptyText != null) {
                if(emptyText.isEmpty())
                    Toast.makeText(this, "Enter name!", Toast.LENGTH_SHORT).show()
                else{
                    enteredName = emptyText.toString()
                    val intent = Intent(this, QuizQuestionsActivity::class.java)
                    intent.putExtra("nameKey", enteredName)
                    startActivity(intent)
                    finish()
                }
            }

        }
    }
}