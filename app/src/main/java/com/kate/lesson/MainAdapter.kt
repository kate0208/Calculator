package com.kate.lesson

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kate.lesson.databinding.HolderMainBinding

/**
 * Created by Rex on 2022/5/4.
 */
class MainAdapter : ListAdapter<String, MainViewHolder>(MainDiffUtil()) {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
    val itemBinding = HolderMainBinding.inflate(
      LayoutInflater.from(parent.context), parent, false
    )

    return MainViewHolder(itemBinding)
  }

  override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
    val text = getItem(position)
    holder.bind(text)
  }

}

class MainViewHolder(private val binding: HolderMainBinding) : RecyclerView.ViewHolder(binding.root) {
  fun bind(text: String) {
    binding.text.text = text
  }
}

class MainDiffUtil : DiffUtil.ItemCallback<String>() {
  override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
    return true
  }

  override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
    return false
  }

}