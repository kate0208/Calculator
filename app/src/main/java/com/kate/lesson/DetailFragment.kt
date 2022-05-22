package com.kate.lesson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kate.lesson.databinding.FragmentDetailBinding

/**
 * Created by Kate on 2022/5/20.
 */
class DetailFragment : Fragment() {
  private var _binding: FragmentDetailBinding? = null

  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = FragmentDetailBinding.inflate(inflater, container, false)
    val view = binding.root
    return view
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val args = DetailFragmentArgs.fromBundle(requireArguments())

    val data: Affirmation = args.affirmation

    binding.textView.text = data.title
    binding.imageView.setImageResource(data.imageResourceId)

  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

}