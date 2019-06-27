package com.josancamon19.bydrecsoccerapi.di.matches

import androidx.lifecycle.ViewModel
import com.josancamon19.bydrecsoccerapi.ui.viewmodels.FixturesViewModel
import com.josancamon19.bydrecsoccerapi.ui.viewmodels.ResultsViewModel
import com.josancamon19.bydrecsoccerapi.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MatchesViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(FixturesViewModel::class)
    internal abstract fun bindFixturesViewModel(viewModel: FixturesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ResultsViewModel::class)
    internal abstract fun bindResultsViewModel(viewModel: ResultsViewModel): ViewModel
}