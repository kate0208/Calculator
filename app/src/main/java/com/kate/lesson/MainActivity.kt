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

    binding.calculate.setOnClickListener {
      val tall = binding.editTall.text.toString().toDoubleOrNull() ?: return@setOnClickListener
      val weight = binding.editWeight.text.toString().toDoubleOrNull() ?: return@setOnClickListener
      val age = binding.editAge.text.toString().toDoubleOrNull() ?: return@setOnClickListener
      val bmi = weight / ((tall / 100) * (tall / 100))
      binding.tvBmi.text = "BMI \n${String.format("%.2f", bmi)}"

      if (binding.boy.isChecked) {
        binding.tvWeight.text = "標準體重 \n${String.format("%.2f", ((tall - 80) * 0.7))}"
        binding.tvFat.text = "體脂肪 \n${String.format("%.2f", (bmi * 1.39 + age * 0.16 - 19.34))}"
      } else {
        binding.tvWeight.text = "標準體重\n" + String.format("%.2f", ((tall - 70) * 0.6))
        binding.tvFat.text = "體脂肪\n" + String.format("%.2f", (bmi * 1.39 + age * 0.16 - 9))
      }
    }
  }
}