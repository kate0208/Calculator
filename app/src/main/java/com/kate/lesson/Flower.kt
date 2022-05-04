package com.kate.lesson

import androidx.annotation.DrawableRes

/**
 * Created by Rex on 2022/5/4.
 */
data class Flower(
  val id: Long,
  val name: String,
  @DrawableRes
  val image: Int,
  val description: String
)