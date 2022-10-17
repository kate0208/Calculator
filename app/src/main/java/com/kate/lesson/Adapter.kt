package com.kate.lesson

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kate.lesson.databinding.HolderBinding

/**
 * Created by Kate on 2022/10/17.
 */
class MainAdapter : ListAdapter<Int, MainViewHolder>(MainDiffUtil()) {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
    val itemBinding = HolderBinding.inflate(
      LayoutInflater.from(parent.context), parent, false
    )

    return MainViewHolder(itemBinding)

  }

  override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
    val affirmation = getItem(position)
    holder.bind(affirmation)
  }

}


class MainViewHolder(private val binding: HolderBinding) : RecyclerView.ViewHolder(binding.root) {

  fun bind(drawableId: Int) {

    binding.image.setImageResource(drawableId)

  }

}

class MainDiffUtil : DiffUtil.ItemCallback<Int>() {
  override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
    return oldItem == newItem
  }

  override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
    return oldItem == newItem
  }

}