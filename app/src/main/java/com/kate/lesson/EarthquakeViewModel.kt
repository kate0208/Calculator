package com.kate.lesson

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * Created by Kate on 2022/9/29.
 */
class EarthquakeViewModel : ViewModel() {


  private val _earthquake = MutableLiveData<List<Earthquake>>()
  val earthquake: LiveData<List<Earthquake>> = _earthquake


  fun getEarthquake() {
    viewModelScope.launch {
      try {
        val response = EarthquakeApi.retrofitService.getEarthquakeInfo()
        _earthquake.value = response.records.earthquake

      } catch (e: Exception) {
        e.printStackTrace()
      }
    }
  }
}

