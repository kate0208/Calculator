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

    binding.switchCompat.setOnCheckedChangeListener { buttonView, isChecked /*isChecked 是參數 */ ->
      saveSwitchData()
    }
  }

  private fun readSwitchData() {
    val settings = getSharedPreferences(DATA, 0)
    val isChecked = settings.getBoolean(SWITCH, false)
    binding.switchCompat.isChecked = isChecked
  }

  private fun saveSwitchData() {
    val settings = getSharedPreferences(DATA, 0)
    settings.edit()
      .putBoolean(SWITCH, binding.switchCompat.isChecked)
      .apply()
  }

  companion object {
    private const val DATA = "DATA"
    private const val SWITCH = "SWITCH"
  }
}