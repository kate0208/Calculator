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

    binding.button1.setOnClickListener {
      setTitleText(getString(R.string.click_result))
    }

    binding.button2.setOnLongClickListener {
      setTitleText(getString(R.string.click_result2))
      return@setOnLongClickListener true
      // 因為在lambda裡面 所以要指名道姓 return哪個東西
    }

  }

  private fun setTitleText(text: String) {
    binding.title.text = text
  }


}