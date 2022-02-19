package com.kate.lesson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kate.lesson.databinding.ActivityMainBinding
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
  private var number = 1

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)
    binding.imageView.setImageResource(R.drawable.dog3)

    binding.plus.setOnClickListener {
      number += 1
      calculate()
    }

    binding.minus.setOnClickListener {
      number -= 1
      calculate()
    }

  }

  private fun calculate() {
    when (number.absoluteValue % 3) {
      0 -> binding.imageView.setImageResource(R.drawable.dog2)
      1 -> binding.imageView.setImageResource(R.drawable.dog3)
      else -> binding.imageView.setImageResource(R.drawable.dog1)
    }
  }
}