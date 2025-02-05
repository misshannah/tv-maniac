package com.thomaskioko.tvmaniac.seasons.api

import com.thomaskioko.tvmaniac.core.db.Seasons
import kotlinx.coroutines.flow.Flow
import org.mobilenativefoundation.store.store5.StoreReadResponse

interface SeasonsRepository {

    suspend fun getSeasons(traktId: Long): List<Seasons>
    fun observeSeasonsStoreResponse(traktId: Long): Flow<StoreReadResponse<List<Seasons>>>
}
