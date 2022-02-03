package com.kate.lesson

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

  private lateinit var editText: EditText
  private lateinit var kmTextView: TextView
  private lateinit var convertButton: Button

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    editText = findViewById<EditText>(R.id.editText)
    kmTextView = findViewById<TextView>(R.id.kmTextView)
    convertButton = findViewById<Button>(R.id.convertButton)

    convertButton.setOnClickListener {
      val miles = editText.text.toString().toDoubleOrNull()

      if (miles != null) {
        val km = (miles * 1.61).toString()
        kmTextView.text = km
      } else {
        kmTextView.text = getString(R.string.plz)
      }

    }
  }
}