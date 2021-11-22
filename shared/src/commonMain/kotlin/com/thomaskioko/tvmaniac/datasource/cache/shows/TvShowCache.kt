package com.thomaskioko.tvmaniac.datasource.cache.shows

import com.thomaskioko.tvmaniac.datasource.cache.Show
import com.thomaskioko.tvmaniac.datasource.enums.ShowCategory
import com.thomaskioko.tvmaniac.datasource.enums.TimeWindow
import kotlinx.coroutines.flow.Flow

interface TvShowCache {

    fun insert(show: Show)

    fun insert(list: List<Show>)

    fun getTvShow(showId: Int): Flow<Show>

    fun getTvShows(): Flow<List<Show>>

    fun getWatchlist(): Flow<List<Show>>

    fun getTvShows(category: ShowCategory, timeWindow: TimeWindow): List<Show>

    fun getTvShowsByCategory(category: ShowCategory): List<Show>

    fun getFeaturedTvShows(category: ShowCategory, timeWindow: TimeWindow): List<Show>

    fun updateShowDetails(showId: Int, showStatus: String, seasonIds: List<Int>)

    fun updateWatchlist(showId: Int, isInWatchlist: Boolean)

    fun deleteTvShows()
}
