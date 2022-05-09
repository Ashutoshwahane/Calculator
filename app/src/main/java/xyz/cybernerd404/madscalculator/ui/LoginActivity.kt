package xyz.cybernerd404.madscalculator.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import xyz.cybernerd404.madscalculator.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            loginBtn.setOnClickListener {
                if (loginEmailET.text.toString().equals("flybase", true) && loginPasswordET.text.toString().equals("flybase", true)){
                    Intent(this@LoginActivity, MainActivity::class.java).apply {
                        startActivity(this)
                    }
                } else {
                    Toast.makeText(this@LoginActivity, "Please enter the correct login ID and password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}