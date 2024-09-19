package com.example.renregis

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.renregis.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = intent.getStringExtra("email")
        val username = intent.getStringExtra("username")
        val fullName = intent.getStringExtra("fullName")
        val phone = intent.getStringExtra("phone")
        val gender = intent.getStringExtra("gender")

        binding.showEmail.text = "$email"
        binding.showUsername.text = "$username"
        binding.showFullName.text = "$fullName"
        binding.showPhone.text = "$phone"
        binding.showGender.text = "$gender"
    }
}