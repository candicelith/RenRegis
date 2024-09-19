package com.example.renregis

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.renregis.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE)

        binding.btnRegister.setOnClickListener {
            val emailInput = binding.email.text.toString()
            val fullNameInput = binding.fullName.text.toString()
            val usernameInput = binding.username.text.toString()
            val phoneInput = binding.phone.text.toString()
            val genderInput = binding.gender.text.toString()
            val passwordInput = binding.password.text.toString()

            val editor = sharedPreferences.edit()
            editor.putString("email", emailInput)
            editor.putString("fullName", fullNameInput)
            editor.putString("username", usernameInput)
            editor.putString("phone", phoneInput)
            editor.putString("gender", genderInput)
            editor.putString("password", passwordInput)
            editor.apply()

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}