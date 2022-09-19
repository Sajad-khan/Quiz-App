package khan.sajad.example.quiztime

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import khan.sajad.example.quiztime.databinding.ActivityResultBinding

class Result : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val score = intent.extras?.getString("score")
        val name = intent.extras?.getString("name")?.trimEnd()
        val maxScore = intent.extras?.getString("maxScore")
        binding.tvCongratulate.text = getString(R.string.congratulate, name)
        binding.tvScore.text = getString(R.string.score, score,maxScore)
        binding.btnRestart.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}