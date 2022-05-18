package com.kate.lesson

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kate.lesson.databinding.FragmentAffirmationBinding

class AffirmationFragment: Fragment() {

  private var _binding: FragmentAffirmationBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

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

    val list = affirmationList(requireContext())
    val adapter = MainAdapter()
    binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    binding.recyclerView.adapter = adapter

    adapter.submitList(list)
  }

  private fun affirmationList(context: Context): List<Affirmation> {
    return listOf(
      Affirmation(
        title = context.getString(R.string.affirmation1),
        imageResourceId = R.drawable.image1
      ),
      Affirmation(
        title = context.getString(R.string.affirmation2),
        imageResourceId = R.drawable.image2
      ),
      Affirmation(
        title = context.getString(R.string.affirmation3),
        imageResourceId = R.drawable.image3
      ),
      Affirmation(
        title = context.getString(R.string.affirmation4),
        imageResourceId = R.drawable.image4
      ),
      Affirmation(
        title = context.getString(R.string.affirmation5),
        imageResourceId = R.drawable.image5
      ),
      Affirmation(
        title = context.getString(R.string.affirmation6),
        imageResourceId = R.drawable.image6
      ),
      Affirmation(
        title = context.getString(R.string.affirmation7),
        imageResourceId = R.drawable.image7
      ),
      Affirmation(
        title = context.getString(R.string.affirmation8),
        imageResourceId = R.drawable.image8
      ),
      Affirmation(
        title = context.getString(R.string.affirmation9),
        imageResourceId = R.drawable.image9
      ),
      Affirmation(
        title = context.getString(R.string.affirmation10),
        imageResourceId = R.drawable.image10
      ),
    )
  }


}