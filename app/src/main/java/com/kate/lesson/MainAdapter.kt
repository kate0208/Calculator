package com.kate.lesson

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kate.lesson.databinding.HolderBinding

class MainAdapter : ListAdapter<Affirmation, MainViewHolder>(MainDiffUtil()) {
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

  fun bind(affirmation: Affirmation) {
    binding.textView.text = affirmation.title
    binding.imageView.setImageResource(affirmation.imageResourceId)
  }

}

class MainDiffUtil : DiffUtil.ItemCallback<Affirmation>() {
  override fun areItemsTheSame(oldItem: Affirmation, newItem: Affirmation): Boolean {
    return oldItem == newItem
  }

  override fun areContentsTheSame(oldItem: Affirmation, newItem: Affirmation): Boolean {
    return oldItem == newItem
  }

}