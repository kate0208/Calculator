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

    /*binding取代findViewById
    binding.ID.setOnClickListener{ }
    */
    binding.clear.setOnClickListener {
      binding.account.setText("")
      binding.passcode.setText("")
    }
    binding.enter.setOnClickListener {
      println("account = ${binding.account.text}, passcode = ${binding.passcode.text}")
    }

  }
}