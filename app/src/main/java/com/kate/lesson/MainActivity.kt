package com.kate.lesson

import android.content.DialogInterface
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
    binding.helloWorld.setOnClickListener {
      AlertDialog.Builder(this)
        .setMessage("Your BMI is 1234")
        .setTitle("BMI")
        .setPositiveButton("OK", object :DialogInterface.OnClickListener{
          override fun onClick(dialog: DialogInterface?, which: Int) {
            Toast.makeText(this@MainActivity, "Hello", Toast.LENGTH_LONG).show()
          }
        })
        .setNegativeButton("Cancel", null)
        .show()
    }
  }
}