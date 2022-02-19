package com.kate.lesson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kate.lesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    binding.plus.setOnClickListener {
      var number = binding.number.text.toString().toIntOrNull()
      if (number != null) {
        number += 1
        binding.number.setText(number.toString())
      }
    }

    binding.minus.setOnClickListener {
      var number = binding.number.text.toString().toIntOrNull()
      if (number != null) {
        number -= 1
        binding.number.setText(number.toString())
      }
    }

  }
}