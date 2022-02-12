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

    /*binding取代findViewById
    binding.ID.setOnClickListener{ }
    */
    binding.clear.setOnClickListener {
      binding.account.setText("")
      binding.passcode.setText("")
    }
    binding.enter.setOnClickListener {
      checkLoginInfo()
    }

  }

  private fun checkLoginInfo() {
    println("account = ${binding.account.text}, passcode = ${binding.passcode.text}")
    Toast.makeText(this, getString(R.string.login_success), Toast.LENGTH_SHORT).show()

  }
}