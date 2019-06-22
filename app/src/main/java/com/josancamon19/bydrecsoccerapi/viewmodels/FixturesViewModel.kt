package com.josancamon19.bydrecsoccerapi.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.josancamon19.bydrecsoccerapi.adapters.addHeadersToList
import com.josancamon19.bydrecsoccerapi.models.DataItem
import com.josancamon19.bydrecsoccerapi.models.Match
import com.josancamon19.bydrecsoccerapi.network.MatchesApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber

class FixturesViewModel : ViewModel() {
    private val jobViewModel: Job = Job()
    private val uiScope: CoroutineScope = CoroutineScope(Dispatchers.Main + jobViewModel)

    private val _fixtures = MutableLiveData<List<Match>>()

    private val _fixturesWithHeaders = MutableLiveData<List<DataItem>>()
    val fixturesWithHeaders: LiveData<List<DataItem>>
        get() = _fixturesWithHeaders

    private val _pbVisibility = MutableLiveData<Boolean>()
    val pbVisibility: LiveData<Boolean>
        get() = _pbVisibility

    init {
        _pbVisibility.value = true
        loadFixtures()
    }

    private fun loadFixtures() {
        uiScope.launch {
            val fixtures = MatchesApi.retrofitService.getFixturesAsync()
            try {
                val fixturesList = fixtures.await()
                _fixtures.value = fixturesList
                _fixturesWithHeaders.value = addHeadersToList(fixturesList)
                _pbVisibility.value = false
            } catch (e: Exception) {
                Timber.e(e)
                _pbVisibility.value = false
            }
        }
    }

    fun filterByCompetition(competition:String){
        if (competition == "Display all"){
            _fixturesWithHeaders.value  = addHeadersToList(_fixtures.value)
            return
        }
        val matches = mutableListOf<Match>()
        _fixtures.value?.forEach {
            if(it.competitionStage.competition.name == competition){
                matches.add(it)
            }
        }
        _fixturesWithHeaders.value = addHeadersToList(matches)
    }

    override fun onCleared() {
        super.onCleared()
        jobViewModel.cancel()
    }
}