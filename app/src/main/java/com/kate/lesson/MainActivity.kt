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
      saveData()
      checkLoginInfo()
    }

    readData()

  }

  private fun checkLoginInfo() {
    println("account = ${binding.account.text}, passcode = ${binding.passcode.text}")
    Toast.makeText(this, getString(R.string.login_success), Toast.LENGTH_SHORT).show()

  }

  companion object {
    private const val DATA = "DATA"
    private const val ACCOUNT = "ACCOUNT"
    private const val PASSWORD = "PASSWORD"
  }

  private fun readData() {
    val settings = getSharedPreferences(DATA, 0)
    binding.account.setText(settings.getString(ACCOUNT, ""))
    binding.passcode.setText(settings.getString(PASSWORD, ""))
  }

  private fun saveData() {
    val settings = getSharedPreferences(DATA, 0)
    settings.edit()
      .putString(ACCOUNT, binding.account.text.toString())
      .putString(PASSWORD,  binding.passcode.text.toString())
      .apply()
  }

}