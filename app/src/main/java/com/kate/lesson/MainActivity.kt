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
    binding.switchCompat.setOnCheckedChangeListener { buttonView, isChecked /*isChecked 是參數 */ ->
      if (isChecked) {
        Toast.makeText(this, getString(R.string.switch_checked), Toast.LENGTH_SHORT).show()
      } else {
        Toast.makeText(this, getString(R.string.switch_not_checked), Toast.LENGTH_SHORT).show()

      }
    }
  }
}