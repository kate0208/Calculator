package com.kate.lesson

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kate.lesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)
    binding.female.isChecked = true
    binding.pickGender.setOnClickListener {
      showGender()
    }
  }

  private fun showGender() {
//    if (binding.female.isChecked) {
//      Toast.makeText(this, "你選擇了美女", Toast.LENGTH_SHORT).show()
//    } else if (binding.male.isChecked) {
//      Toast.makeText(this, "你選擇了宅男", Toast.LENGTH_SHORT).show()
//
//    }
    when {
      binding.female.isChecked -> Toast.makeText(this, "你選擇了美女", Toast.LENGTH_SHORT).show()
      binding.male.isChecked -> Toast.makeText(this, "你選擇了宅男", Toast.LENGTH_SHORT).show()
    }

  }
}
