package com.thomaskioko.tvmaniac.seasondetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thomaskioko.tvmaniac.presentation.seasondetails.Loading
import com.thomaskioko.tvmaniac.presentation.seasondetails.SeasonDetailsAction
import com.thomaskioko.tvmaniac.presentation.seasondetails.SeasonDetailsState
import com.thomaskioko.tvmaniac.presentation.seasondetails.SeasonDetailsStateMachine
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import me.tatarka.inject.annotations.Assisted
import me.tatarka.inject.annotations.Inject

@Inject
class SeasonDetailsViewModel(
    @Assisted savedStateHandle: SavedStateHandle,
    private val stateMachine: (Long) -> SeasonDetailsStateMachine,
) : ViewModel() {

    private val showId: Long = savedStateHandle["showId"]!!

    val state: MutableStateFlow<SeasonDetailsState> = MutableStateFlow(Loading)

    init {

        viewModelScope.launch {
            stateMachine(showId).state
                .collect {
                    state.value = it
                }
        }
    }

    fun dispatch(action: SeasonDetailsAction) {
        viewModelScope.launch {
            stateMachine(showId).dispatch(action)
        }
    }
}
