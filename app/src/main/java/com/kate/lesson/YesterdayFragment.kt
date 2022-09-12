package com.kate.lesson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kate.lesson.databinding.FragmentYesterdayBinding

/**
 * Created by Kate on 2022/9/12.
 */
class YesterdayFragment : Fragment() {
  private var _binding: FragmentYesterdayBinding? = null

  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = FragmentYesterdayBinding.inflate(inflater, container, false)
    val view = binding.root
    return view
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null

  }
}