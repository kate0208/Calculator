package com.kate.lesson

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kate.lesson.model.Rank
import com.kate.lesson.model.RankTime
import com.kate.lesson.network.RankApi
import kotlinx.coroutines.launch

/**
 * Created by Kate on 2022/9/12.
 */
class RankViewModel : ViewModel() {

  private val _ranks = MutableLiveData<List<Rank>>()
  val ranks: LiveData<List<Rank>> = _ranks


  fun getRank(rankTime: RankTime) {
    viewModelScope.launch {
      try {
        val response = RankApi.retrofitService.getRank(rankTime.name.lowercase())
        _ranks.value = response.data

      } catch (e: Exception) {
        e.printStackTrace()
      }
    }
  }

}