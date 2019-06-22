package com.josancamon19.bydrecsoccerapi.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.josancamon19.bydrecsoccerapi.models.Match
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL: String = "https://storage.googleapis.com/cdn-og-test-api/test-task/"


val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .build()

interface MatchesService {
    @GET("fixtures.json")
    fun getFixturesAsync(): Deferred<List<Match>>

    @GET("results.json")
    fun getResultsAsync(): Deferred<List<Match>>
}

object MatchesApi {
    val retrofitService: MatchesService by lazy { retrofit.create(MatchesService::class.java) }
}