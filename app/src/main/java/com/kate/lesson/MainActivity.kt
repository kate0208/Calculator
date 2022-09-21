package com.kate.lesson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.kate.lesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)
    binding.snackBar.setOnClickListener {
      Snackbar.make(binding.root, getString(R.string.snack_text), Snackbar.LENGTH_SHORT).show()
    }
  }
}