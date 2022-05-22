package com.kate.lesson

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

/**
 * Created by Rex on 2022/5/4.
 */
@Parcelize
data class Flower(
  val id: Long,
  val name: String,
  @DrawableRes
  val image: Int,
  val description: String
) : Parcelable