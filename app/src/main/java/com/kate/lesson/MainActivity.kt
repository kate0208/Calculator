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
    readSwitchData()
    binding.enter.setOnClickListener {
      number += 1
      binding.number.text = number.toString()
      saveSwitchData()
    }

  }

  private fun readSwitchData() {
    val settings = getSharedPreferences(DATA, 0)
    val number = settings.getString(NUMBER, "0")
    binding.number.text = number
    this.number = number?.toIntOrNull() ?: 0   //assign 第11行的值   打this是因為有兩個名字一樣 指的是class裡的number
  }

  private fun saveSwitchData() {
    val settings = getSharedPreferences(DATA, 0)
    settings.edit()
      .putString(NUMBER, binding.number.text.toString())
      .apply()
  }

  companion object {
    private const val DATA = "DATA"
    private const val NUMBER = "NUMBER"
  }

}