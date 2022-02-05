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

    binding.convertButton.setOnClickListener {
      val miles = binding.editText.text.toString().toDoubleOrNull()

      if (miles != null) {
        val km = (miles * 1.61).toString()
        binding.kmTextView.text = km
      } else {
        binding.kmTextView.text = getString(R.string.plz)
      }

    }
  }
}