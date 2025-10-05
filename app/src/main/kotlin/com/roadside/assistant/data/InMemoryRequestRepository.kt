package com.roadside.assistant.data

import com.roadside.assistant.data.model.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.UUID

class InMemoryRequestRepository : RequestRepository {
    private val store = MutableStateFlow<List<Request>>(emptyList())

    override fun observeRequests(): Flow<List<Request>> = store.asStateFlow()

    override suspend fun getRequest(id: String): Request? = store.value.firstOrNull { it.id == id }

    override suspend fun createRequest(
        authorId: String,
        category: RequestCategory,
        description: String,
        location: GeoPoint
    ): String {
        val id = UUID.randomUUID().toString()
        val new = Request(
            id = id,
            authorId = authorId,
            category = category,
            description = description,
            location = location
        )
        store.value = listOf(new) + store.value
        return id
    }
}
