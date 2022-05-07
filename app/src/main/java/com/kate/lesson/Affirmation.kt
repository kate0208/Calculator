package com.kate.lesson

import androidx.annotation.DrawableRes

/**
 * Created by Rex on 2022/5/4.
 */
data class Affirmation(
  val title: String,
  @DrawableRes val imageResourceId: Int
)