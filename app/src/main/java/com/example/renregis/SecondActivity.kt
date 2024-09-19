package com.example.renregis

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.renregis.databinding.ActivityMainBinding
import com.example.renregis.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {
            val usernameInput = binding.username.text.toString()
            val passwordInput = binding.password.text.toString()

            val savedUsername = sharedPreferences.getString("username", "")
            val savedPassword = sharedPreferences.getString("password", "")

            val savedEmail = sharedPreferences.getString("email", "")
            val savedFullName = sharedPreferences.getString("fullName", "")
            val savedPhone = sharedPreferences.getString("phone", "")
            val savedGender = sharedPreferences.getString("gender", "")

            if (usernameInput == savedUsername && passwordInput == savedPassword) {
                val intent = Intent(this, ThirdActivity::class.java)
                intent.putExtra("email", savedEmail)
                intent.putExtra("username", savedUsername)
                intent.putExtra("fullName", savedFullName)
                intent.putExtra("phone", savedPhone)
                intent.putExtra("gender", savedGender)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Not Valid", Toast.LENGTH_SHORT).show()
            }
        }
    }
}