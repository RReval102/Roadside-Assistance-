package com.roadside.assistant.feature.create

import androidx.lifecycle.ViewModel
import com.roadside.assistant.data.InMemoryRequestRepository
import com.roadside.assistant.data.RequestRepository
import com.roadside.assistant.data.model.GeoPoint
import com.roadside.assistant.data.model.RequestCategory

class CreateRequestViewModel(
    private val repository: RequestRepository = InMemoryRequestRepository()
) : ViewModel() {
    suspend fun create(
        authorId: String,
        category: RequestCategory,
        description: String,
        lat: Double,
        lon: Double
    ): String {
        return repository.createRequest(
            authorId = authorId,
            category = category,
            description = description,
            location = GeoPoint(lat, lon)
        )
    }
}
