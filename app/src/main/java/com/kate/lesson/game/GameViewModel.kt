package com.kate.lesson.game

import android.util.Log
import androidx.lifecycle.ViewModel

/**
 * Created by Kate on 2022/5/29.
 */

class GameViewModel : ViewModel() {
  // The current word
  var word = ""

  // The current score
  var score = 0

  // The list of words - the front of the list is the next word to guess
  private lateinit var wordList: MutableList<String>

  init {
    Log.i("GameViewModel", "GameViewModel created!")

    resetList()
    nextWord()
  }

  override fun onCleared() {
    super.onCleared()
    Log.i("GameViewModel", "GameViewModel destroyed!")
  }

  /**
   * Resets the list of words and randomizes the order
   */
  private fun resetList() {
    wordList = mutableListOf(
      "queen",
      "hospital",
      "basketball",
      "cat",
      "change",
      "snail",
      "soup",
      "calendar",
      "sad",
      "desk",
      "guitar",
      "home",
      "railway",
      "zebra",
      "jelly",
      "car",
      "crow",
      "trade",
      "bag",
      "roll",
      "bubble"
    )
    wordList.shuffle()
  }

  /**
   * Moves to the next word in the list
   */
  private fun nextWord() {
    //Select and remove a word from the list
    if (wordList.isEmpty()) {
      // gameFinished()
    } else {
      word = wordList.removeAt(0)
    }
  }

  /** Methods for buttons presses **/
  fun onSkip() {
    score--
    nextWord()
  }

  fun onCorrect() {
    score++
    nextWord()
  }

}