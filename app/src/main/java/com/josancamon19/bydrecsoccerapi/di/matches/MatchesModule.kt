package com.josancamon19.bydrecsoccerapi.di.matches

import com.josancamon19.bydrecsoccerapi.adapters.lists.FixturesListAdapter
import com.josancamon19.bydrecsoccerapi.adapters.lists.ResultsListAdapter
import com.josancamon19.bydrecsoccerapi.network.MatchesApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MatchesModule {

    @MatchesScope
    @Provides
    fun provideMatchesApi(retrofit: Retrofit): MatchesApi {
        val retrofitService: MatchesApi by lazy { retrofit.create(MatchesApi::class.java) }
        return retrofitService
    }

    @MatchesScope
    @Provides
    fun provideFixturesListAdapter(): FixturesListAdapter {
        return FixturesListAdapter()
    }

    @MatchesScope
    @Provides
    fun provideResultsListAdapter(): ResultsListAdapter {
        return ResultsListAdapter()
    }
}