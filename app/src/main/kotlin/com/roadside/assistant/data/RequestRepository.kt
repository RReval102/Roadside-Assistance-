package com.roadside.assistant.data

import com.roadside.assistant.data.model.*
import kotlinx.coroutines.flow.Flow

interface RequestRepository {
    fun observeRequests(): Flow<List<Request>>
    suspend fun getRequest(id: String): Request?
    suspend fun createRequest(
        authorId: String,
        category: RequestCategory,
        description: String,
        location: GeoPoint
    ): String
}
