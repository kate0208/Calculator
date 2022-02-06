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
      val num = binding.editText.text.toString().toIntOrNull()

      if (num != null) {

        var sum = 0

        for (i in 1..num) {
          // sum = sum+i;
          sum += i
        }

        binding.kmTextView.text = sum.toString()
      } else {
        binding.kmTextView.text = getString(R.string.plz)
      }

    }
  }
}