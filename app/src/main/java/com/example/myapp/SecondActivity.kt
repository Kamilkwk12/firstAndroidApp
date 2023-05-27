package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.myapp.databinding.SecondLayoutBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: SecondLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("SavedData")) {
            binding.savedText.text = intent.getStringExtra("SavedData")
        }

    }
}