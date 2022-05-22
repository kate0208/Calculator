package com.kate.lesson

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kate.lesson.databinding.HolderMainBinding

/**
 * Created by Rex on 2022/5/4.
 */
class FlowerAdapter : ListAdapter<Flower, FlowerViewHolder>(FlowerDiffUtil()) {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder {
    val itemBinding = HolderMainBinding.inflate(
      LayoutInflater.from(parent.context), parent, false
    )
    return FlowerViewHolder(itemBinding)
  }

  override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
    val data = getItem(position)
    holder.bind(data)
  }

}

class FlowerViewHolder(private val binding: HolderMainBinding) : RecyclerView.ViewHolder(binding.root) {
  fun bind(flower: Flower) {
    binding.flowerImage.setImageResource(flower.image)
    binding.flowerText.text = flower.name
    binding.flowerDescription.text = flower.description

    binding.root.setOnClickListener {
      it.findNavController().navigate(
        FlowerListFragmentDirections.actionFlowerFragmentToDetailFragment(flower)
      )
    }
  }
}

class FlowerDiffUtil : DiffUtil.ItemCallback<Flower>() {
  override fun areItemsTheSame(oldItem: Flower, newItem: Flower): Boolean {
    return oldItem == newItem
  }

  override fun areContentsTheSame(oldItem: Flower, newItem: Flower): Boolean {
    return oldItem == newItem
  }

}