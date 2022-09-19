package com.kate.lesson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kate.lesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
  private var number = 0

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)


    binding.plus.setOnClickListener {
      val currentNumber = binding.number.text.toString().toIntOrNull()
      if (currentNumber != null) {
        number = currentNumber + 1
        binding.number.setText(number.toString())
      }
    }

    binding.minus.setOnClickListener {
      val currentNumber = binding.number.text.toString().toIntOrNull()
      if (currentNumber != null) {
        number = currentNumber - 1
        binding.number.setText(number.toString())
      }
    }

  }
}