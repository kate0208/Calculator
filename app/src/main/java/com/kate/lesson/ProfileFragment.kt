package com.kate.lesson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.kate.lesson.databinding.FragmentProfileBinding

/**
 * Created by Kate on 2022/9/13.
 */
class ProfileFragment : Fragment() {

  private var _binding: FragmentProfileBinding? = null

  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = FragmentProfileBinding.inflate(inflater, container, false)
    val view = binding.root
    return view
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val fragmentArgs = ProfileFragmentArgs.fromBundle(requireArguments())
    val rank = fragmentArgs.rank


    Glide.with(binding.profilePhoto)
      .load(rank.user.profilePicture)
      .circleCrop()
      .into(binding.profilePhoto)

    binding.nameTextView.text = rank.user.nickname
    binding.rankNumber.text = rank.ranking.toString()
    binding.pointNumber.text = rank.points.toString()

    binding.online.text = if (rank.isOnAir) getString(R.string.online) else getString(R.string.offline)

  }


  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}

