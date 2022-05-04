package com.kate.lesson

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kate.lesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    val adapter = FlowerAdapter()

    binding.recyclerView.layoutManager = LinearLayoutManager(this)
    binding.recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    binding.recyclerView.adapter = adapter

    val list = flowerList(this)
    adapter.submitList(list)
  }

  private fun flowerList(context: Context): List<Flower> {
    return listOf(
      Flower(
        id = 1,
        name = context.getString(R.string.flower1_name),
        image = R.drawable.rose,
        description = context.getString(R.string.flower1_description)
      ),
      Flower(
        id = 2,
        name = context.getString(R.string.flower2_name),
        image = R.drawable.freesia,
        description = context.getString(R.string.flower2_description)
      ),
      Flower(
        id = 3,
        name = context.getString(R.string.flower3_name),
        image = R.drawable.lily,
        description = context.getString(R.string.flower3_description)
      ),
      Flower(
        id = 4,
        name = context.getString(R.string.flower4_name),
        image = R.drawable.sunflower,
        description = context.getString(R.string.flower4_description)
      ),
      Flower(
        id = 5,
        name = context.getString(R.string.flower5_name),
        image = R.drawable.peony,
        description = context.getString(R.string.flower5_description)
      ),
      Flower(
        id = 6,
        name = context.getString(R.string.flower6_name),
        image = R.drawable.daisy,
        description = context.getString(R.string.flower6_description)
      ),
      Flower(
        id = 7,
        name = context.getString(R.string.flower7_name),
        image = R.drawable.lilac,
        description = context.getString(R.string.flower7_description)
      ),
      Flower(
        id = 8,
        name = context.getString(R.string.flower8_name),
        image = R.drawable.marigold,
        description = context.getString(R.string.flower8_description)
      ),
      Flower(
        id = 9,
        name = context.getString(R.string.flower9_name),
        image = R.drawable.poppy,
        description = context.getString(R.string.flower9_description)
      ),
      Flower(
        id = 10,
        name = context.getString(R.string.flower10_name),
        image = R.drawable.daffodil,
        description = context.getString(R.string.flower10_description)
      ),
      Flower(
        id = 11,
        name = context.getString(R.string.flower11_name),
        image = R.drawable.dahlia,
        description = context.getString(R.string.flower11_description)
      )
    )
  }
}