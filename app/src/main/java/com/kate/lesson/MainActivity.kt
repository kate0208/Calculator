package com.kate.lesson

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.kate.lesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    val item = arrayOf("麥當勞", "肯德基", "鹹酥雞", "牛肉麵", "滷肉飯")

    binding.food.setOnClickListener {
      AlertDialog.Builder(this)
        .setTitle("今天你想吃什麼")
        .setItems(item) { DialogInterface, i ->
          Toast.makeText(this, "今天想吃${item[i]}", Toast.LENGTH_SHORT).show()
        }
        .setNeutralButton("減肥不吃好了", { DialogInterface, i ->
          Toast.makeText(this, "不吃拉哼！", Toast.LENGTH_SHORT).show()
        })
        .show()
    }

  }
}