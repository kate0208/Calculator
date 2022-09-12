package com.kate.lesson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.kate.lesson.databinding.FragmentTodayBinding
import com.kate.lesson.model.RankTime
import com.kate.lesson.network.RankApi
import kotlinx.coroutines.launch

/**
 * Created by Kate on 2022/9/12.
 */
class TodayFragment : Fragment() {
  private var _binding: FragmentTodayBinding? = null

  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = FragmentTodayBinding.inflate(inflater, container, false)
    val view = binding.root
    return view
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    lifecycleScope.launch {
      try {
        val rank = RankApi.retrofitService.getRank(RankTime.TODAY.name.lowercase())
        println(">>>>>>> rank = ${rank.message}")
        println(">>>>>>> rank = ${rank.data}")
      } catch (e: Exception) {
        e.printStackTrace()
      }
    }

  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}