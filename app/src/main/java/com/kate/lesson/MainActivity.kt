package com.kate.lesson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kate.lesson.databinding.ActivityMainBinding
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
  private var number = 0
  private val list = listOf(R.drawable.dog1, R.drawable.dog2, R.drawable.dog3, R.drawable.dog4, R.drawable.dog5)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)
    binding.imageView.setImageResource(list[0])

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
    val image = list[number.absoluteValue % list.size]
    binding.imageView.setImageResource(image)

//    when (number.absoluteValue % 3) {
//      0 -> binding.imageView.setImageResource(R.drawable.dog2)
//      1 -> binding.imageView.setImageResource(R.drawable.dog3)
//      else -> binding.imageView.setImageResource(R.drawable.dog1)
//    }
  }
}