/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kate.lesson.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.kate.lesson.databinding.GameFragmentBinding

/**
 * Fragment where the game is played
 */
class GameFragment : Fragment() {

  private val viewModel by viewModels<GameViewModel>()

  private var _binding: GameFragmentBinding? = null

  // This property is only valid between onCreateView and
// onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = GameFragmentBinding.inflate(inflater, container, false)
    val view = binding.root
    return view
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.correctButton.setOnClickListener {
      viewModel.onCorrect()
    }

    binding.skipButton.setOnClickListener {
      viewModel.onSkip()
    }

    viewModel.score.observe(viewLifecycleOwner) { newScore ->
      binding.scoreText.text = newScore.toString()
    }

    viewModel.word.observe(viewLifecycleOwner) { newWord ->
      binding.wordText.text = newWord
    }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  /**
   * Called when the game is finished
   */
  private fun gameFinished() {
    val action = GameFragmentDirections.actionGameToScore(viewModel.score.value ?: 0)
    findNavController(this).navigate(action)
  }

  /** Methods for updating the UI **/


}
