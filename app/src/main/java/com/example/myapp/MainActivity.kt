package com.example.myapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp.databinding.MainLayoutBinding
import com.example.myapp.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    private lateinit var binding: MainLayoutBinding
    private val mainVm by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (mainVm.click > 0) {
            binding.textView.text = mainVm.click.toString()
        }
        binding.button.setOnClickListener {
            mainVm.click+=1
            binding.textView.text = mainVm.click.toString()
        }

        binding.sendBtn.setOnClickListener {
            val textData = binding.textField.text.toString()
            val explicitIntent = Intent(applicationContext, SecondActivity::class.java)
            explicitIntent.putExtra("SavedData", textData)
            startActivity(explicitIntent)
        }

        val adapter = FirstAdapter(createContacts())
        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.adapter = adapter
    }

    private fun createContacts() : List<Contact> = buildList  {
        for (i in 0..500) {
            val newContact = Contact("$i", "$i")
            add(newContact)
        }
    }

}

