package com.kate.lesson

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
  private lateinit var titleTextView: TextView
  private lateinit var button1: Button
  private lateinit var button2: Button
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    titleTextView = findViewById<TextView>(R.id.title)

    button1 = findViewById<Button>(R.id.button1)
    button2 = findViewById<Button>(R.id.button2)

    button1.setOnClickListener {
      setTitleText(getString(R.string.click_result))
    }

    button2.setOnLongClickListener {
      setTitleText(getString(R.string.click_result2))
      return@setOnLongClickListener true
    }
  }

  private fun setTitleText(text: String) {
    titleTextView.text = text
  }


}