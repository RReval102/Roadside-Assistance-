package com.roadside.assistant.feature.detail

import androidx.lifecycle.ViewModel
import com.roadside.assistant.data.InMemoryRequestRepository
import com.roadside.assistant.data.RequestRepository
import com.roadside.assistant.data.model.Request

class RequestDetailViewModel(
    private val repository: RequestRepository = InMemoryRequestRepository()
) : ViewModel() {
    suspend fun load(id: String): Request? = repository.getRequest(id)
}
