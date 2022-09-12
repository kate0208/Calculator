package com.kate.lesson.model

import com.squareup.moshi.Json

/**
 * Created by Kate on 2022/9/12.
 */
data class Response(
  @Json(name = "Message") val message: String,
  @Json(name = "Status") val status: String,
  val data: List<Rank>
)

data class Rank(
  val isLiveMaster: Boolean,
  val isOnAir: Boolean,
  val isTrackable: Boolean,
  val points: Int,
  val ranking: Int,
  val user: User
)

data class User(
  val frameUrl: String,
  val id: String,
  val levelId: String,
  val levelNum: Int,
  val nickname: String,
  val profilePicture: String
)

enum class RankTime {
  TODAY,
  YESTERDAY,
  WEEK,
  MONTH
}