package com.kate.lesson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kate.lesson.databinding.FragmentAffirmationBinding

class AffirmationFragment : Fragment() {

  private var _binding: FragmentAffirmationBinding? = null

  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  private val model = MainModel()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = FragmentAffirmationBinding.inflate(inflater, container, false)
    val view = binding.root
    return view
  }


  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val list = model.affirmationList(requireContext())
    val adapter = MainAdapter()
    binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    binding.recyclerView.adapter = adapter

    adapter.submitList(list)

    binding.nextButton.setOnClickListener {
      view.findNavController().navigate(AffirmationFragmentDirections.actionAffirmationFragmentToDetailFragment())
    }
  }


}