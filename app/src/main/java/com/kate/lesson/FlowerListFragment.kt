package com.kate.lesson

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kate.lesson.databinding.FragmentFlowerListBinding


class FlowerListFragment : Fragment() {

  private var _binding: FragmentFlowerListBinding? = null

  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = FragmentFlowerListBinding.inflate(inflater, container, false)
    val view = binding.root
    return view
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val adapter = FlowerAdapter()

    binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    binding.recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
    binding.recyclerView.adapter = adapter

    val list = flowerList(requireContext())
    adapter.submitList(list)
  }

  private fun flowerList(context: Context): List<Flower> {
    return listOf(
      Flower(
        id = 1,
        name = context.getString(R.string.flower1_name),
        image = R.drawable.rose,
        description = context.getString(R.string.flower1_description)
      ),
      Flower(
        id = 2,
        name = context.getString(R.string.flower2_name),
        image = R.drawable.freesia,
        description = context.getString(R.string.flower2_description)
      ),
      Flower(
        id = 3,
        name = context.getString(R.string.flower3_name),
        image = R.drawable.lily,
        description = context.getString(R.string.flower3_description)
      ),
      Flower(
        id = 4,
        name = context.getString(R.string.flower4_name),
        image = R.drawable.sunflower,
        description = context.getString(R.string.flower4_description)
      ),
      Flower(
        id = 5,
        name = context.getString(R.string.flower5_name),
        image = R.drawable.peony,
        description = context.getString(R.string.flower5_description)
      ),
      Flower(
        id = 6,
        name = context.getString(R.string.flower6_name),
        image = R.drawable.daisy,
        description = context.getString(R.string.flower6_description)
      ),
      Flower(
        id = 7,
        name = context.getString(R.string.flower7_name),
        image = R.drawable.lilac,
        description = context.getString(R.string.flower7_description)
      ),
      Flower(
        id = 8,
        name = context.getString(R.string.flower8_name),
        image = R.drawable.marigold,
        description = context.getString(R.string.flower8_description)
      ),
      Flower(
        id = 9,
        name = context.getString(R.string.flower9_name),
        image = R.drawable.poppy,
        description = context.getString(R.string.flower9_description)
      ),
      Flower(
        id = 10,
        name = context.getString(R.string.flower10_name),
        image = R.drawable.daffodil,
        description = context.getString(R.string.flower10_description)
      ),
      Flower(
        id = 11,
        name = context.getString(R.string.flower11_name),
        image = R.drawable.dahlia,
        description = context.getString(R.string.flower11_description)
      )
    )
  }


}
