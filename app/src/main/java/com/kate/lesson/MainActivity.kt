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
    readSwitchData()

    binding.copy.setOnClickListener {
      binding.textView.text = binding.editText.text.toString()
      saveSwitchData()
    }

  }

  private fun readSwitchData() {
    val settings = getSharedPreferences(DATA, 0)
    val text = settings.getString(TEXT, "")
    binding.textView.text = text
    // binding.editText.setText(text)  如果是存editText 要用setText(text)!!
  }

  private fun saveSwitchData() {
    val settings = getSharedPreferences(DATA, 0)
    settings.edit()
      .putString(TEXT, binding.textView.text.toString())
      .apply()
  }

  companion object {
    private const val DATA = "DATA"
    private const val TEXT = "TEXT"

  }
}

