package com.thomaskioko.tvmaniac.lastairepisodes.api

import com.thomaskioko.tvmaniac.shared.core.FlowInteractor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

class ObserveAirEpisodesInteractor constructor(
    private val repository: LastAirEpisodeRepository,
) : FlowInteractor<Int, List<LastAirEpisode>>() {

    override fun run(params: Int): Flow<List<LastAirEpisode>> =
        repository.observeAirEpisodes(params)
            .map { it.toLastAirEpisodeList() }
            .distinctUntilChanged()
}
