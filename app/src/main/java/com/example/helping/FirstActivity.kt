// File: FirstActivity.kt
package com.example.helping

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.helping.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
