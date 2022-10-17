package com.kate.lesson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.kate.lesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    val adapter=MainAdapter()
    binding.recyclerView.layoutManager=LinearLayoutManager(this)
    binding.recyclerView.adapter=adapter



    val list= listOf(
      R.drawable.pic_2,
      R.drawable.pic_3,
      R.drawable.pic_4,
      R.drawable.pic_5,
      R.drawable.pic_6,
      R.drawable.pic_7,
      R.drawable.pic_8,
      R.drawable.pic_9,
      R.drawable.pic_10,
      R.drawable.pic_11,
      R.drawable.pic_12,
      R.drawable.pic_13,
      R.drawable.pic_14,
      R.drawable.pic_15,
      R.drawable.pic_16,
      R.drawable.pic_17,
      R.drawable.pic_18,
    )
    adapter.submitList(list)
  }
}