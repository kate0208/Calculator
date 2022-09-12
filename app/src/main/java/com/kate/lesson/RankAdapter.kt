package com.kate.lesson

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.kate.lesson.databinding.HolderRankBinding
import com.kate.lesson.model.Rank

/**
 * Created by Kate on 2022/9/5.
 */
class RankAdapter : ListAdapter<Rank, RankViewHolder>(DiffCallback) {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankViewHolder {
    return RankViewHolder(HolderRankBinding.inflate(LayoutInflater.from(parent.context)))
  }

  override fun onBindViewHolder(holder: RankViewHolder, position: Int) {
    val rank = getItem(position)
    holder.bind(rank)
  }

}

class RankViewHolder(private var binding: HolderRankBinding) : RecyclerView.ViewHolder(binding.root) {

  fun bind(rank: Rank) {
    binding.photo.load(rank.user.profilePicture) {
      transformations(CircleCropTransformation())
    }
    binding.nameTextView.text = rank.user.nickname
  }

}

object DiffCallback : DiffUtil.ItemCallback<Rank>() {

  override fun areItemsTheSame(oldItem: Rank, newItem: Rank): Boolean {
    return oldItem.user == newItem.user
  }

  override fun areContentsTheSame(oldItem: Rank, newItem: Rank): Boolean {
    return oldItem == newItem
  }
}