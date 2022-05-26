package com.kate.lesson

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.kate.lesson.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  private var i = 0
  private var job: Job? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    setupOnClick()

  }

  private fun setupOnClick() {
    binding.start.setOnClickListener {
      Toast.makeText(this, "start", Toast.LENGTH_LONG).show()
      startTimer()
    }
    binding.pause.setOnClickListener {
      Toast.makeText(this, "pause", Toast.LENGTH_LONG).show()
      pauseTimer()
    }
  }

  private fun pauseTimer() {
    job?.cancel()
    job = null
  }

  private fun startTimer() {

    if (job != null) {
      return
    }

    job = lifecycleScope.launch {
      withContext(Dispatchers.IO) {
        while (true) {
          delay(100)
          i++
          withContext(Dispatchers.Main) {
            binding.timer.text = i.toString()
          }
        }
      }
    }
  }
}