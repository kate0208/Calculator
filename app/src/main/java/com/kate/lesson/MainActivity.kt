package com.kate.lesson

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.kate.lesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private val adapter = EarthquakeAdapter()
  private val viewModel: EarthquakeViewModel by viewModels()
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    binding.recycler.layoutManager = LinearLayoutManager(this)
    binding.recycler.adapter = adapter

    viewModel.earthquake.observe(this) {
      adapter.submitList(it)
    }
    viewModel.getEarthquake()
  }
}