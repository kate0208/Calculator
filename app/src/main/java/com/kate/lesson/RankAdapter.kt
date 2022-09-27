package com.kate.lesson

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kate.lesson.databinding.HolderRankBinding
import com.kate.lesson.model.Rank

/**
 * Created by Kate on 2022/9/5.
 */
class RankAdapter(
  private val onItemClickListener: (Rank) -> Unit
) : ListAdapter<Rank, RankViewHolder>(DiffCallback) {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankViewHolder {
    return RankViewHolder(
      HolderRankBinding.inflate(LayoutInflater.from(parent.context), parent, false),
      onItemClickListener
    )
  }

  override fun onBindViewHolder(holder: RankViewHolder, position: Int) {
    val rank = getItem(position)
    holder.bind(rank)
  }

}

class RankViewHolder(
  private var binding: HolderRankBinding,
  private val onItemClickListener: (Rank) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

  fun bind(rank: Rank) {
    binding.root.setOnClickListener {
      onItemClickListener(rank)
    }
    Glide.with(binding.photo)
      .load(rank.user.profilePicture)
      .circleCrop()
      .into(binding.photo)
    binding.nameTextView.text = rank.user.nickname
    binding.number.text = rank.ranking.toString()

    if (rank.ranking <= 3) {
      binding.number.setTextColor(ContextCompat.getColor(itemView.context, R.color.primaryDarkColor))
    } else {
      binding.number.setTextColor(ContextCompat.getColor(itemView.context, R.color.primaryTextColor))
    }

    binding.point.text = rank.points.toString()
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