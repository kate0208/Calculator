package com.kate.lesson

/**
 * Created by Kate on 2022/9/28.
 */
data class EarthquakeResponse(
  val records: Records
)

data class Records(
  val earthquake: List<Earthquake>
)

data class Earthquake(
  val earthquakeNo: Int,
  val reportContent: String,
  val reportImageURI: String,
  val web: String,
  val shakemapImageURI: String,
  val earthquakeInfo: EarthquakeInfo
)

data class EarthquakeInfo(
  val originTime: String,
  val magnitude: Magnitude
)

data class Magnitude(
  val magnitudeType: String,
  val magnitudeValue: Int
)