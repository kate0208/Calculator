/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.kate.lesson.overview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kate.lesson.network.MarsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

  val response = MutableLiveData<String>()

  /**
   * Call getMarsRealEstateProperties() on init so we can display status immediately.
   */
  init {
    getMarsRealEstateProperties()
  }

  /**
   * Sets the value of the status LiveData to the Mars API status.
   */
  private fun getMarsRealEstateProperties() {

    MarsApi.retrofitService.getProperties().enqueue(object : Callback<String> {

      override fun onFailure(call: Call<String>, t: Throwable) {
        println(">>>>> onFailure ${t}")
      }

      override fun onResponse(call: Call<String>, response: Response<String>) {
        this@OverviewViewModel.response.value = response.body()
      }
    })

  }
}
