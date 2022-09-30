package com.kate.lesson

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kate.lesson.databinding.HolderEarthquakeBinding

/**
 * Created by Kate on 2022/9/29.
 */
class EarthquakeAdapter : ListAdapter<Earthquake, RankViewHolder>(DiffCallback) {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankViewHolder {
    return RankViewHolder(
      HolderEarthquakeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
  }

  override fun onBindViewHolder(holder: RankViewHolder, position: Int) {
    val earthquake = getItem(position)
    holder.bind(earthquake)
  }


}

class RankViewHolder(
  private var binding: HolderEarthquakeBinding
) : RecyclerView.ViewHolder(binding.root) {

  fun bind(earthquake: Earthquake) {
    binding.earthquakeReportContent.text = earthquake.reportContent
    binding.earthquakeNumber.text = itemView.context.getString(R.string.no, earthquake.earthquakeNo.toString())
    binding.type.text = earthquake.earthquakeInfo.magnitude.magnitudeType
    binding.value.text = earthquake.earthquakeInfo.magnitude.magnitudeValue.toString()

    Glide.with(binding.earthquakeImage)
      .load(earthquake.shakemapImageURI)
      .into(binding.earthquakeImage)

//    Glide.with(binding.photo)
//      .load(rank.user.profilePicture)
//      .circleCrop()
//      .into(binding.photo)
//    binding.nameTextView.text = rank.user.nickname
//    binding.number.text = rank.ranking.toString()
//
//    if (rank.ranking <= 3) {
//      binding.number.setTextColor(ContextCompat.getColor(itemView.context, R.color.primaryDarkColor))
//    } else {
//      binding.number.setTextColor(ContextCompat.getColor(itemView.context, R.color.primaryTextColor))
//    }
//
//    binding.point.text = rank.points.toString()
  }

}

object DiffCallback : DiffUtil.ItemCallback<Earthquake>() {

  override fun areItemsTheSame(oldItem: Earthquake, newItem: Earthquake): Boolean {
    return oldItem.earthquakeNo == newItem.earthquakeNo
  }

  override fun areContentsTheSame(oldItem: Earthquake, newItem: Earthquake): Boolean {
    return oldItem == newItem
  }
}