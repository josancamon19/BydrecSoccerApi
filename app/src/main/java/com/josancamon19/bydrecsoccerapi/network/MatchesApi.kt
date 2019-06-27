package com.josancamon19.bydrecsoccerapi.network

import com.josancamon19.bydrecsoccerapi.models.Match
import kotlinx.coroutines.Deferred
import retrofit2.http.GET


interface MatchesApi {
    @GET("fixtures.json")
    fun getFixturesAsync(): Deferred<List<Match>>

    @GET("results.json")
    fun getResultsAsync(): Deferred<List<Match>>
}
