package com.kate.lesson

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

/**
 * Created by Kate on 2022/5/4.
 */
@Parcelize
data class Affirmation(
  val title: String,
  @DrawableRes val imageResourceId: Int
) : Parcelable