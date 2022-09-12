package com.kate.lesson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kate.lesson.databinding.FragmentWeeklyBinding


/**
 * Created by Kate on 2022/9/12.
 */
class WeeklyFragment : Fragment() {
  private var _binding: FragmentWeeklyBinding? = null

  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = FragmentWeeklyBinding.inflate(inflater, container, false)
    val view = binding.root
    return view
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null

  }
}