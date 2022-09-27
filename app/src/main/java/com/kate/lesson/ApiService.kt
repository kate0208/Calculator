package com.kate.lesson

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

/**
 * Created by Kate on 2022/9/28.
 */

private const val BASE_URL = "https://opendata.cwb.gov.tw"

private val interceptor = HttpLoggingInterceptor().apply {
  setLevel(HttpLoggingInterceptor.Level.BODY)
}
private val client = OkHttpClient.Builder()
  .addInterceptor(interceptor)
  .build()

private val moshi = Moshi.Builder()
  .add(KotlinJsonAdapterFactory())
  .build()

private val retrofit = Retrofit.Builder()
  .addConverterFactory(MoshiConverterFactory.create(moshi))
  .baseUrl(BASE_URL)
  .client(client)
  .build()

interface EarthquakeApiService {

  @GET("api/v1/rest/datastore/E-A0015-001?Authorization=rdec-key-123-45678-011121314")
  suspend fun getEarthquakeInfo(): EarthquakeResponse

}

object EarthquakeApi {
  val retrofitService: EarthquakeApiService by lazy { retrofit.create(EarthquakeApiService::class.java) }
}
