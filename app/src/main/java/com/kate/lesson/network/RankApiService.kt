package com.kate.lesson.network

import com.kate.lesson.model.Response
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Kate on 2022/9/12.
 */

private const val BASE_URL = "https://api.xtars.com"

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

interface RankApiService {

  @GET("api/v2/ranking/app/all/receiver/point/{time}")
  suspend fun getRank(
    @Path("time") time: String
  ): Response

}

object RankApi {
  val retrofitService: RankApiService by lazy { retrofit.create(RankApiService::class.java) }
}